package com.example.myprojects.review_application.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

    public static void main(String... args) throws ParseException {
        Date date;
        SimpleDateFormat obj = new SimpleDateFormat("yyyy/MM/dd");
        date = obj.parse("2021/05/22");
        System.out.println(date);


    }
}
