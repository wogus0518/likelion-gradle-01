package com.line;

import com.line.parser.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineReaderContext<T> {
    Parser<T> parser;
    boolean isRemoveColumnName = true;

    public LineReaderContext(Parser<T> parser) {
        this.parser = parser;
    }

    public List<T> readLines(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String str;
        if (isRemoveColumnName) {
            reader.readLine();
        }
        while ((str = reader.readLine()) != null) {
            result.add(parser.parse(str));
        }
        return result;
    }


}
