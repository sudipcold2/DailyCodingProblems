package problem12;

public class StairCaseDP {

    public static int countUniqueWays(int n){

        int dp[] = new int[n];
        if(n == 1){
            return 1;
        }

        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i < n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(countUniqueWays(4));
    }


}
