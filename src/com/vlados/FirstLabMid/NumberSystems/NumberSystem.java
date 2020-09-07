package com.vlados.FirstLabMid.NumberSystems;

public class NumberSystem {
    private final char[] hexChars = {'A', 'B', 'C', 'D', 'E', 'F'};

    private boolean isNumberCorrect(int num) {
        return num >= 0;
    }

    public String toBinarySystem(int num) {
        if(!isNumberCorrect(num)) throw new IllegalArgumentException("Number must be prime and positive");
        StringBuilder result = new StringBuilder();
        do {
            if(num%2 == 1) result.append("1");
            else result.append("0");
            num/=2;

        } while(num>=1);
        return result.reverse().toString();
    }

    public String toOctalSystem(int num) {
        if(!isNumberCorrect(num)) throw new IllegalArgumentException("Number must be prime and positive");
        StringBuilder result = new StringBuilder();
        do {
            result.append(num%8);
            num/=8;

        } while(num>=1);
        return result.reverse().toString();
    }

    public String toHexSystem(int num) {
        if(!isNumberCorrect(num)) throw new IllegalArgumentException("Number must be prime and positive");
        StringBuilder result = new StringBuilder();
        do {
            if(num % 16 <= 9) result.append(num%16);
            else {
                result.append(hexChars[(num%16) - 10]);
            }
            num/=16;
        } while(num>=1);
        return result.reverse().toString();
    }
}
