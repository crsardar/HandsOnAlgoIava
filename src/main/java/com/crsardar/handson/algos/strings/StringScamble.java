package com.crsardar.handson.algos.strings;

public class StringScamble {


    public static void main(String[] args) {

        System.out.println(Wildcard("$**+*{2} 9mmmrrrkbb"));
        System.out.println(Wildcard("+++++* abcdehhhhhh"));
    }

    private static String Wildcard(final String str) {
        String result = "false";
        if (str == null || str.length() <= 0) {
            return result;
        }

        String strings[] = str.split(" ");

        if (strings == null || strings.length != 2) {
            return result;
        }

        char[] regex = strings[0].toCharArray();
        char[] targetChars = strings[1].toCharArray();

        int indexX = 0;
        int indexY = 0;

        final int regexLen = regex.length;
        while (indexX < regexLen) {

            final char rex = regex[indexX];
            if (rex == '$') {

                char tar = targetChars[indexY];
                if (Character.isDigit(tar)) {
                    indexX++;
                    indexY++;
                } else {
                    result = "false";
                    break;
                }
            } else if (rex == '+') {

                indexX++;
                indexY++;

            } else if (rex == '*') {
                if (((indexX + 1) < regexLen) && (regex[indexX + 1] == '{')) {
                    if (((indexX + 3) < regexLen) && (regex[indexX + 3] == '}')
                            && (Character.isDigit(regex[indexX + 2]))) {

                        char tar = regex[indexX + 2];
                        int a = Character.getNumericValue(tar);
                        if (findPattern(targetChars, targetChars[indexY], indexY, a)) {

                            indexX += 4;
                            indexY += a;
                        } else {
                            result = "false";
                            break;
                        }
                    } else {
                        result = "false";
                        break;
                    }
                } else {
                    if (findPattern(targetChars, targetChars[indexY], indexY, 3)) {

                        indexX++;
                        indexY += 3;
                    } else {
                        result = "false";
                        break;
                    }
                }

            } else {
                result = "false";
                break;
            }
        }

        if (indexX == regexLen && indexY == targetChars.length) {
            result = "true";
        }


        return result;

    }

    private static boolean findPattern(char charArr[], char c, int indexY, int n) {

        boolean found = true;

        for (int i = 0; i < n; i++) {
            if (indexY >= charArr.length) {
                found = false;
                break;
            }

            char t = charArr[indexY];
            if (c != t) {
                found = false;
                break;
            }
            indexY++;
        }
        return found;
    }
}
