package br.com.api.todo.list.service.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date convertToDate(final String value) {
        Date date = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            date = sdf.parse(value);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
