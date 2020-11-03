package com.vlados.lab5.part3.main;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class EncodingReader extends FilterReader {
    /**
     * Creates a new filtered reader.
     *
     * @param in a Reader object providing the underlying stream.
     * @throws NullPointerException if {@code in} is {@code null}
     */
    protected EncodingReader(Reader in) {
        super(in);
    }

    public int read(char key) throws IOException {
        return super.read() - (int)key;
    }
}
