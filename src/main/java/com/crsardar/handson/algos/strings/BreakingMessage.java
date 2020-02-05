package com.crsardar.handson.algos.strings;
/**
 * @author Chittaranjan Sardar
 */
public class BreakingMessage {

    public int breakingMessage(final String msgString, final int msgLength) {

        final int lenth = msgString.length();
        int messageCount = 0;
        int count = 0;
        int index = 0;
        int lastSpace = 0;

        while (index < lenth) {

            char c = msgString.charAt(index);
            count++;

            if (count == msgLength) {

                // Many if/s and sequences are mandatory to tackle ArrayIndexOutOfBound and different cases separately
                if (c == ' ') {                                     // Ideal case a space as the current location

                    messageCount++;
                    System.out.println(" Message " + messageCount + " = [" + msgString.substring((index - count + 1), index + 1) + "]");
                    count = 0;

                } else if (index == (lenth - 1)) {                  // it is the last char of the string

                    messageCount++;
                    System.out.println(" Message " + messageCount + " = [" + msgString.substring((index - count + 1), index + 1) + "]");
                    count = 0;

                } else if (msgString.charAt(index + 1) == ' ') {    // it is the last char of a word, as next char is a space

                    messageCount++;
                    System.out.println(" Message " + messageCount + " = [" + msgString.substring((index - count + 1), index + 1) + "]");
                    count = 0;

                } else {

                    messageCount++;
                    System.out.println(" Message " + messageCount + " = [" + msgString.substring((index - count + 1), lastSpace + 1) + "]");
                    count = 0;
                    index = lastSpace;

                }

            }

            if (c == ' ') {

                lastSpace = index;

            }

            index++;

        }

        if (count > 0) {

            messageCount++;
            System.out.println(" Message " + messageCount + " = [" + msgString.substring((index - count), index) + "]"); // As now index == msgString.length()
        }

        return messageCount;
    }
}
