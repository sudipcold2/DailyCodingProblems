package problem4;

public class MissingPositiveIntegerInArray {

        private int segregate(int a[], int size) {
            int i, temp, j = 0;
            for (i = 0; i < size; i++) {
                if (a[i] <= 0) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    j++;
                }
            }

            return j;
        }


        private int findMisingPositive(int a[], int size) {
            int i;
            for (i = 0; i < size; i++) {
                int x = Math.abs(a[i]);
                if ((x - 1) < size && a[x - 1] > 0) {
                    a[x - 1] = -a[x - 1];
                }
            }

            for (i = 0; i < size; i++) {
                if (a[i] > 0) {
                    return i + 1;
                }
            }

            return size + 1;

        }


        public int findMissingNumber(int a[]) {
            int size = a.length;
            int minus = segregate(a, size);
            int newArr[] = new int[size - minus];
            int j = 0;

            for (int i = minus; i < size; i++, j++) {
                newArr[j] = a[i];
            }

            return findMisingPositive(newArr, newArr.length);

        }
}

