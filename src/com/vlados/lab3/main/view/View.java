package com.vlados.lab3.main.view;

import com.vlados.lab3.main.models.shapes.Shape;

import java.util.List;
import java.util.Locale;

public class View {
    private static ResourceManager manager;

    static {
        manager = new ResourceManager();
    }

    public void showShapes(List<Shape> shapes) {
        if(shapes.isEmpty()) this.showMessage(ResourceBundleKeys.EMPTY_LIST);
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println();
    }

    public void showMessage(String message) {
        String value = manager.getValue(message);
        System.out.println(value);
    }

    public void setLocale(Locale locale) {
        manager.setLocale(locale);
    }
}
