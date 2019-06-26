package com.crsardar.handson.algos.array;

import org.junit.Test;

public class RotateAnArrayTest {

    @Test
    public void rotationTest(){

        int arr[] = {1, 2, 3, 4, 5, 6, 7};

        RotateAnArray rotateAnArray = new RotateAnArray();
        rotateAnArray.rotateArray(15, arr);

        for (int i : arr){
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
