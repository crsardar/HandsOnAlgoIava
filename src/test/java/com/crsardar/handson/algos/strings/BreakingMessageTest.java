package com.crsardar.handson.algos.strings;

import org.junit.Assert;
import org.junit.Test;

public class BreakingMessageTest {

    @Test
    public void testBreakingMsm() {

        BreakingMessage breakingMessage = new BreakingMessage();
        int smsCount = breakingMessage.breakingMessage("SMS messages are really great thing!  Ha ha ha ", 12);
        Assert.assertTrue(smsCount == 4);

        smsCount = breakingMessage.breakingMessage("SMS messages", 12);
        Assert.assertTrue(smsCount == 1);

        smsCount = breakingMessage.breakingMessage("", 12);
        Assert.assertTrue(smsCount == 0);

        smsCount = breakingMessage.breakingMessage("S", 12);
        Assert.assertTrue(smsCount == 1);


    }
}
