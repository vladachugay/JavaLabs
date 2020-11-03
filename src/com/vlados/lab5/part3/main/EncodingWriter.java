package com.vlados.lab5.part3.main;

import java.io.*;

public class EncodingWriter extends FilterWriter {

    /**
     * Create a new filtered writer.
     *
     * @param out a Writer object to provide the underlying stream.
     * @throws NullPointerException if {@code out} is {@code null}
     */
    protected EncodingWriter(Writer out) {
        super(out);
    }

    public void write(int c, char key) throws IOException {
        super.write(c + (int)key);
    }
}
