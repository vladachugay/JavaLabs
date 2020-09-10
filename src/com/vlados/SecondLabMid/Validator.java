package com.vlados.SecondLabMid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {

    public Boolean checkChoice(String choice) {
        return choice.trim().equals("1") || choice.trim().equals("2") || choice.trim().equals("3");
    }

    public Boolean checkFullName(String str) {
        return  str.trim().isEmpty();
    }

    public Date checkDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        try {
            date = formatter.parse(dateStr.trim());
        } catch (ParseException e) {
            return null;
        }
        return date;
    }
}
