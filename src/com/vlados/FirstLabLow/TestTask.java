package com.vlados.FirstLabLow;

import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;

public class TestTask {
    Task task = new Task();
    @Test
    public void testCheckForLatinWords() {
        Assert.assertTrue(task.checkForLatinLetters("string"));
        Assert.assertFalse(task.checkForLatinLetters("string.строка"));
        Assert.assertFalse(task.checkForLatinLetters("имовл"));
        Assert.assertTrue(task.checkForLatinLetters("AdadcTVH"));
        Assert.assertTrue(task.checkForLatinLetters("A"));
        Assert.assertFalse(task.checkForLatinLetters("и"));
    }
    @Test
    public void testCheckForNumOfVowelLetters() {
        Assert.assertTrue(task.checkForNumOfVowelLetters(" aabb"));
        Assert.assertTrue(task.checkForNumOfVowelLetters("yourtr"));
        Assert.assertFalse(task.checkForNumOfVowelLetters("cat"));
        Assert.assertFalse(task.checkForNumOfVowelLetters("Consonant"));
    }

    @Test
    public void testFilterWords() {
        String[] expected = {"like", "very"};
        String[] actual = task.filterWords("I like very much  ооти ьоткрbdgvi");
        Assert.assertTrue(Arrays.equals(actual, expected));
    }

}
