package problem9;

public class MaxStolenFromNonAdjcHouses {

    //Time complex-o(n) space complex-o(n)
    public int maxStole(int hval[], int n){

        if(n == 0){
            return 0;
        }

        if(n == 1){
            return hval[0];
        }

        if(n == 2){
            return hval[1];
        }

        int dp[] = new int[n];

        dp[0] = hval[0];
        dp[1] = Math.max(hval[0],hval[1]);

        for(int i = 2; i < n; i++){

            dp[i] = Math.max(dp[i-2] + hval[i], dp[i - 1]);

        }

        return dp[n-1];
    }

    //time complex-o(n) space-complex - o(1)
    public int maxStoleOptimized(int hval[], int n){

        if(n == 0){
            return 0;
        }

        int value1 = hval[0];

        if(n == 1){
            return value1;
        }

        int value2 = Math.max(hval[0], hval[1]);

        if(n == 2){
            return value2;
        }

        int maxVal = 0;

        for(int i = 2; i < n; i++){

            maxVal = Math.max(value1 + hval[i], value2);
            value1 = value2;
            value2 = maxVal;

        }

        return maxVal;
    }

}
