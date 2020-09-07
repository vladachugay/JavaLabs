package com.vlados.FirstLabMid.NumberSystems;

import org.junit.Assert;
import org.junit.Test;

public class TestNumberSystems {

    NumberSystem numberSystem = new NumberSystem();
    @Test
    public void testToBinarySystem() {
        Assert.assertEquals(numberSystem.toBinarySystem(23), "10111");
        Assert.assertEquals(numberSystem.toBinarySystem(1569), "11000100001");
        Assert.assertEquals(numberSystem.toBinarySystem(56), "111000");
        Assert.assertEquals(numberSystem.toBinarySystem(7894), "1111011010110");
        Assert.assertEquals(numberSystem.toBinarySystem(347), "101011011");
        Assert.assertEquals(numberSystem.toBinarySystem(129), "10000001");

    }

    @Test
    public void testToOctalSystem() {
        Assert.assertEquals(numberSystem.toOctalSystem(23), "27");
        Assert.assertEquals(numberSystem.toOctalSystem(1569), "3041");
        Assert.assertEquals(numberSystem.toOctalSystem(56), "70");
        Assert.assertEquals(numberSystem.toOctalSystem(7894), "17326");
        Assert.assertEquals(numberSystem.toOctalSystem(347), "533");
        Assert.assertEquals(numberSystem.toOctalSystem(129), "201");

    }

    @Test
    public void testToHexSystem() {
        Assert.assertEquals(numberSystem.toHexSystem(23), "17");
        Assert.assertEquals(numberSystem.toHexSystem(1569), "621");
        Assert.assertEquals(numberSystem.toHexSystem(56), "38");
        Assert.assertEquals(numberSystem.toHexSystem(7894), "1ED6");
        Assert.assertEquals(numberSystem.toHexSystem(347), "15B");
        Assert.assertEquals(numberSystem.toHexSystem(129), "81");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodsForExceptions() {
        numberSystem.toBinarySystem(7.9f);
        numberSystem.toHexSystem(5.5f);
        numberSystem.toOctalSystem(-67f);



    }
}
