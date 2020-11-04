package com.vlados.lab7hard.test.task_1_1;

import com.vlados.lab7hard.main.task_1_1.AbbreviationBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class AbbreviationBuilderTest {


    @Test
    public void build_AllParametersNotNull() {
        List<String> list = Arrays.asList("Name", "Petronomics", "Surname");
        assertEquals("NPS", AbbreviationBuilder.build(list));
    }

    @Test
    public void build_OneOfParametersIsNull() throws Exception {
        List<String> list = Arrays.asList("Name", null, "Surname");
        assertEquals("NS", AbbreviationBuilder.build(list));
    }

    @Test
    public void build_OneOfParametersIsEmptyString() throws Exception {
        List<String> list = Arrays.asList("Name", "", "Surname");
        assertEquals("NS", AbbreviationBuilder.build(list));
    }
}