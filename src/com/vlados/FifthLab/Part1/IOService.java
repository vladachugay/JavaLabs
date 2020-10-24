package com.vlados.FifthLab.Part1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOService {

    BufferedReader in = null;
// розділити на функції цю велику функцію
    // обробити виключну ситуацію, коли  в лісті з строками нічого не буде
    public List<String> getLines(String src) throws IOException {
        List<String> lines = new ArrayList<>();
        String line;
        try {
            in = new BufferedReader(new FileReader(src));
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }
        }
        finally {
            if (in != null) in.close();
        }
        return lines;
    }
}
