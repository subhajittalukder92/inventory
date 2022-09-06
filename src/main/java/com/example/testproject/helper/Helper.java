package com.example.testproject.helper;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class Helper {

    public static Date formatDate(Date date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date returnDate =(Date) formatter.parse(date.toString());
//       DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
//        String dateString = dateTimeFormatter.format(date);
//
////        return new SimpleDateFormat("yyyy-mm-dd").parse(dateString);
//        return new java.sql.Date(date.getTime());

   return  returnDate;
    }
}
