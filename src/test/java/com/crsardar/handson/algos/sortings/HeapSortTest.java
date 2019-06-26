package com.crsardar.handson.algos.sortings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.Random;

public class HeapSortTest<T> {

    private final int TEST_SIZE = 15;
    private final int NO_TESTS = 15;

    @Test
    public void mainTest() {

        for (int n = 0; n < NO_TESTS; n++) {

            Integer[] intArr = getRandomFilledArray();

            System.out.println("\n----------- Before : ");
            for (int i = 0; i < TEST_SIZE; i++) {

                System.out.print(intArr[i] + " ");
            }

            Comparator<Integer> comparator = (a, b) -> a - b;

            HeapSort<Integer> heapSort = new HeapSort();
            intArr = heapSort.sort(intArr, comparator);

            System.out.println("\nAfter : ");
            for (int i = 0; i < TEST_SIZE; i++) {

                System.out.print(intArr[i] + " ");
            }

            for (int i = 0; i < TEST_SIZE - 1; i++) {

                Assert.assertTrue(comparator.compare(intArr[i], intArr[i + 1]) < 1);
            }
        }
    }

    private Integer[] getRandomFilledArray() {

        Random random = new Random();
        int low = 10;
        int high = 100;

        Integer[] intArr = new Integer[TEST_SIZE];

        for (int i = 0; i < TEST_SIZE; i++) {

            intArr[i] = new Integer(random.nextInt(high - low) + low);
        }

        return intArr;
    }
}
