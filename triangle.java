import java.util.Arrays;

public class triangle {
    public static void main(String[] args) {
        int [][]triangle={{2},{3,4},{6,5,7},{4,1,8,3}};
        System.out.println(minimumPathSum(triangle,4));
    }
    public static int minimumPathSum(int[][] triangle, int n) {
        int [][]dp=new int[n][n];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solving_memo(0,0,triangle,n,dp);
//        return solving(0,0,triangle,n);
    }
    //memoization
    public static int solving_memo(int i,int j,int [][]triangle,int n,int [][]dp){
        if(i==n-1){
            return triangle[i][j];
        }
        else if(j>triangle[i].length){
            return (int)Math.pow(10,9);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=triangle[i][j]+solving_memo(i+1,j,triangle,n,dp);
        int down_right=triangle[i][j]+solving_memo(i+1,j+1,triangle,n,dp);
        return dp[i][j]=Math.min(down,down_right);
    }
    //recursive
    public static int solving(int i,int j,int [][]triangle,int n){
        if(i==n-1){
            return triangle[i][j];
        }
        else if(j>triangle[i].length){
            return (int)Math.pow(10,9);
        }
        int down=triangle[i][j]+solving(i+1,j,triangle,n);
        int down_right=triangle[i][j]+solving(i+1,j+1,triangle,n);
        return Math.min(down,down_right);
    }

}
