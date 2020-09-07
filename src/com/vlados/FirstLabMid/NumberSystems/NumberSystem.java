package com.vlados.FirstLabMid.NumberSystems;

public class NumberSystem {
    private final char[] HEX_SYMBOLS  = {'A', 'B', 'C', 'D', 'E', 'F'};

    private boolean isNumberCorrect(String strNum) {
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return Integer.parseInt(strNum) >= 0 ;
    }

    public String toBinarySystem(String strNum) {
        if(!isNumberCorrect(strNum)) throw new IllegalArgumentException("Number must be prime and positive");
        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(strNum);
        do {
            if(n%2 == 1) result.append("1");
            else result.append("0");
            n/=2;

        } while(n>=1);
        return result.reverse().toString();
    }

    public String toOctalSystem(String strNum) {
        if(!isNumberCorrect(strNum)) throw new IllegalArgumentException("Number must be prime and positive");
        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(strNum);
        do {
            result.append(n%8);
            n/=8;

        } while(n>=1);
        return result.reverse().toString();
    }

    public String toHexSystem(String strNum) {
        if(!isNumberCorrect(strNum)) throw new IllegalArgumentException("Number must be prime and positive");
        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(strNum);
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
