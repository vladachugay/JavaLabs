package com.vlados.ThirdLabLow.test;

import com.vlados.ThirdLabLow.main.models.services.IOService;
import com.vlados.ThirdLabLow.main.models.shapes.Shape;
import com.vlados.ThirdLabLow.main.models.shapes.impl.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestIOService {
    IOService ioService = new IOService();

    @Test
    public void testIOShapes() {
        List<Shape> expectedShapes = new ArrayList<>();
        expectedShapes.add(new Circle(3f, "red"));
        expectedShapes.add(new Rectangle(12f, 4f, "green"));
        expectedShapes.add(new Triangle(3f, 4f, 5f, "blue"));

        File file = new File("C:\\Users\\ConnecT\\Desktop\\testIO", "obj.ser");
        ioService.writeShapes(expectedShapes, file);
        List<Shape> actualShape = new ArrayList<>();
        ioService.readShapes(file, actualShape);

        Assert.assertEquals(expectedShapes, actualShape);
    }
}
