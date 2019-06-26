package com.crsardar.handson.algos.array;

public class RotateAnArray {

    public void rotateArray(int rotations, final int[] arr) {

        final int length = arr.length;

        rotations = rotations % length; // if rotations > length

        final int gcd = getGCD(rotations, length);

        for (int i = 0; i < gcd; i++) {

            int temp = arr[i];
            int j = i;

            while (true) {

                int k = j + rotations;

                if (k >= length) {

                    k = k - length;
                }

                if (k == i) {

                    break;
                }

                arr[j] = arr[k];
                j = k;
            }

            arr[j] = temp;

        }

    }

    public int getGCD(int a, int b) {

        if (b == 0) {

            return a;

        } else {

            return getGCD(b, a % b);
        }

    }
}
