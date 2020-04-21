package com.crsardar.handson.algos.random;

import java.util.Scanner;

public class MaxRevenue
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        final int numberOfDays = scanner.nextInt();

        if (numberOfDays <= 0)
        {
            return;
        }

        final int numberOfProducts = scanner.nextInt();
        if (numberOfProducts <= 0)
        {
            return;
        }

        final int[] maxRevenues = new int[numberOfDays];
        for (int day = 0; day < numberOfDays; day++)
        {
            int maxRev = scanner.nextInt();
            if (numberOfProducts > 1)
            {
                for (int product = 1; product < numberOfProducts; product++)
                {
                    int temp = scanner.nextInt();
                    if (temp > maxRev)
                    {
                        maxRev = temp;
                    }
                }
            }

            maxRevenues[day] = maxRev;
        }

        for (int maxRev : maxRevenues)
        {
            System.out.print(maxRev + " ");
        }
    }
}
