package problem9;

public class MaxSumNonAdjcArray {


    /**
     * Runs in constant space and linear time
     *
     * @param arr input array
     * @param n size of the array
     * @return max sum value of adjacent numbers
     */
    public int maxSum(int arr[], int n){

        if(n == 0){
            return 0;
        }

        int value1 = arr[0];
        if(n == 1){
            return value1;
        }

        int value2 = Math.max(arr[0],arr[1]);
        if(n == 2){
            return value2;
        }

        int maxVal = 0;

        for(int i = 2; i < n; i++){
            maxVal = Math.max(arr[i] + value1, value2);
            value1 = value2;
            value2 = maxVal;
        }

        return maxVal;

    }

}
