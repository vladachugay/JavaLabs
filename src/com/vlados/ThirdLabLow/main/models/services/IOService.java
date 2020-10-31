package com.vlados.ThirdLabLow.main.models.services;

import com.vlados.ThirdLabLow.main.models.shapes.Shape;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOService {

    public void writeShapes(List<Shape> shapes, File file) {
        try(ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Shape shape: shapes) {
                objectOutput.writeObject(shape);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public List<Shape> readShapes(File file, List<Shape> shapes){
        try(ObjectInput objectInput = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    shapes.add((Shape)objectInput.readObject());
                }
                catch (EOFException exception) {
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e ) {
            System.out.println(e.getMessage());
        }
        return shapes;
    }
}
