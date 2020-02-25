package com.crsardar.handson.algos.sortings;

import java.util.Scanner;

/**
 * Tests whether two strings are right rotates of each other or not.
 */
public class IsARotationOfString
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        final String word1 = scanner.nextLine();
        final String word2 = scanner.nextLine();

        if (word1 == null || word2 == null || (word1.length() != word2.length()))
        {
            System.out.println(-1);
            return;
        }

        final char[] str1 = word1.toCharArray();
        final char[] str2 = word2.toCharArray();

        int start = -1;
        char ch = str1[0];
        for (int i = 0; i < str2.length; i++)
        {
            if (str2[i] == ch)
            {
                start = i;
                break;
            }
        }

        if (start < 0)
        {
            System.out.println(-1);
            return;
        }

        boolean correct = true;
        int index = start;
        for (int i = 1; i < str1.length; i++)
        {
            index += 1;
            if (index >= str2.length)
            {
                index = 0;
            }

            if (str1[i] != str2[index])
            {
                correct = false;
                break;
            }
        }

        if (correct)
        {
            System.out.println(1);
        }
        else
        {
            System.out.println(-1);
        }
    }

}
