package com.vlados.lab5.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class IOService {

    public String getHTMLFile(URL url) throws IOException {
        StringBuilder sb = new StringBuilder();
        URLConnection connection;
        BufferedReader input = null;
        try {
            int c;
            connection = url.openConnection();
            input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while(((c = input.read()) != -1)) {
                sb.append((char)c);
            }
        }
        finally {
            if(input != null)
                input.close();
        }
        return sb.toString();
    }
}
