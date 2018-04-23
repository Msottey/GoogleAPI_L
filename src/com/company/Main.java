package com.company;

import org.json.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// Open and read SQL
        SQL sql = new SQL();

        // Loop through Table
        sql.sqlConnection();
        sql.readInputs();
        System.out.print(sql.getResultSet().toString());

        // Generate new URL and request
        Distance_Model DM = new Distance_Model();

        //Parse information

        //Write to Table


    }
}
