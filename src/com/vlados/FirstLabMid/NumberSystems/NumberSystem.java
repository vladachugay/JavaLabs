package com.vlados.FirstLabMid.NumberSystems;

public class NumberSystem {
    private final char[] HEX_SYMBOLS  = {'A', 'B', 'C', 'D', 'E', 'F'};

    private boolean isNumberCorrect(float num) {
        return num >= 0 && (int)num == num;
    }

    public String toBinarySystem(float num) {
        if(!isNumberCorrect(num)) throw new IllegalArgumentException("Number must be prime and positive");
        StringBuilder result = new StringBuilder();
        int n = (int)num;
        do {
            if(n%2 == 1) result.append("1");
            else result.append("0");
            n/=2;

        } while(n>=1);
        return result.reverse().toString();
    }

    public String toOctalSystem(float num) {
        if(!isNumberCorrect(num)) throw new IllegalArgumentException("Number must be prime and positive");
        StringBuilder result = new StringBuilder();
        int n = (int)num;
        do {
            result.append(n%8);
            n/=8;

        } while(n>=1);
        return result.reverse().toString();
    }

    public String toHexSystem(float num) {
        if(!isNumberCorrect(num)) throw new IllegalArgumentException("Number must be prime and positive");
        StringBuilder result = new StringBuilder();
        int n = (int)num;
        do {
            if(n % 16 <= 9) result.append(n%16);
            else {
                result.append(HEX_SYMBOLS[(n%16) - 10]);
            }
            n/=16;
        } while(n>=1);
        return result.reverse().toString();
    }
}
