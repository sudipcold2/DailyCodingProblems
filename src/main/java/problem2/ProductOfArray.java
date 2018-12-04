package problem2;

public class ProductOfArray {

    /**
     * Optimized product array approach time complexity bigoh(n) spaceComplexity bigoh(1)
     * @param a input array
     * @return a new modified array with product of each except i
     */
    public static int [] newProductArrayOptimized(int a[]){

        int prodArray [] = new int[a.length];
        int i, temp = 1;
        for(i = 0; i < a.length; i++){
            prodArray[i] = 1;
        }

        for(i=0;i<a.length;i++){
            prodArray[i] = temp;
            temp *= a[i];
        }

        temp =1;

        for(i = a.length - 1; i >= 0; i--){
            prodArray[i] *= temp;
            temp *= a[i];
        }

        return prodArray;
    }


    /**
     * BruteForce approach bigoh(n^2)
     * @param a input array
     * @return a new modified array with product of each except i
     */
    public static int [] newProductArray(int a[]){

        int newArray[] = new int[a.length];
        int product;
        for(int i = 0;i<a.length;i++){
            product = 1;
            for(int j=0;j<a.length;j++){
                if(i==j){
                    continue;
                }else{
                    product *= a[j];
                }
            }
            newArray[i] = product;
        }

        return newArray;
    }

    public static void main(String[] args) {
        int arr[] = {3,2,1};
        int newArray[] = newProductArray(arr);
        for(int a : newArray){
            System.out.print(a+" ");
        }

        System.out.println();

        int newArray2[] = newProductArrayOptimized(arr);
        for (int a : newArray2){
            System.out.print(a + " ");
        }


    }



}
