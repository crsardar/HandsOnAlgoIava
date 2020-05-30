package com.crsardar.handson.algos.random;

import java.util.Scanner;

public class NeedleHayStack
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        final int digit = scanner.nextInt();
        final int number = scanner.nextInt();

        final int hits = countHits(digit, number, 0);

        System.out.println(hits);
    }

    private static int countHits(final int digit, int number, int count)
    {
        if (number > 0)
        {
            final int currentDigit = number % 10;
            if (digit == currentDigit)
            {
                count++;
            }

            number = number / 10;

            return countHits(digit, number, count);
        }

        return count;
    }
}
