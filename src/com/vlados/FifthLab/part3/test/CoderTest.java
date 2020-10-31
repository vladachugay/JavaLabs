package com.vlados.FifthLab.part3.test;

import com.vlados.FifthLab.part3.main.Coder;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class CoderTest {

    @Test
    public void testEncryption() {
        String expected = "Decrypted string";
        Coder coder = new Coder();
        File file = new File("\\C:\\Users\\ConnecT\\Desktop\\testIO\\coder.txt");
        coder.encrypt(expected, file, '1');
        Assert.assertEquals(expected, coder.decrypt(file, '1'));
    }
}
