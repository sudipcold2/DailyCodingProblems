package problem1;

import java.util.Arrays;
import java.util.HashSet;

public class PairSumProblemClass {

    /**
     *
     *Solution with sorting time complexity bigoh(n^2) for quicksort and bigoh(nlogn) for heapsort
     * @param a
     * @param sum
     * @return
     */
    public static boolean pairSumAvailableWithSorting(int a[], int sum){
        Arrays.sort(a);

        int leftIndex = 0;
        int rightIndex = a.length - 1;
        while(leftIndex < rightIndex){
            if((a[leftIndex] + a[rightIndex]) == sum){
                System.out.println("sum available ::" + a[leftIndex] + " and " + a[rightIndex]);
                return true;
            }else if(a[leftIndex] + a[rightIndex] < sum){
                leftIndex ++;
            }
            else{
                rightIndex --;

            }
        }
        return false;
    }


    /**
     * Solution with Hashset time complexity bigoh(n)
     * @param a
     * @param sum
     * @return
     */
    public static boolean pairSumAvailable(int a[], int sum){

        HashSet<Integer> set = new HashSet<Integer>();

        for (int i=0; i< a.length; i++){

            int temp = sum - a[i];

            if( temp>=0 && set.contains(temp) ){
                System.out.println("candidates are :: "+ a[i] +" and " + temp );
                return true;
            }

            set.add(a[i]);
        }

        return false;

    }


    public static void main(String[] args) {
        int arr [] = {1,-1,2,6,2};

        System.out.println("candidate avialable ::"+pairSumAvailable(arr, 8));

        System.out.println("candidate avialable ::"+pairSumAvailableWithSorting(arr, 8));

    }


}
