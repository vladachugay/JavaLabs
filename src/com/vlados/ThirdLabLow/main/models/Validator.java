package com.vlados.ThirdLabLow.main.models;

public class Validator {
    public float checkNumber(String string) throws IllegalArgumentException {
        float num;
        num = Float.parseFloat(string);
        if(num >= 1) return num;
        throw new IllegalArgumentException();
    }

    public String checkString(String s) throws IllegalArgumentException{
        if(s.isEmpty()) throw new IllegalArgumentException();
        return s;
    }
}
