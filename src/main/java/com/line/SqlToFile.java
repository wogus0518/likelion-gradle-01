package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SqlToFile {
    public static void createFile(String filname) {
        File file = new File(filname);
    }

    public static void writeFile(List<Hospital> hospitals, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Hospital hospital : hospitals) {
            writer.write(hospital.getSQL() + "\n");
        }
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        String readFilename = "C:\\Users\\wogus\\Downloads\\서울시 병의원 위치 정보.csv";
        String saveFilename = "insert-hospital.sql";

        LineReaderContext<Hospital> reader = new LineReaderContext<>(new HospitalParser());
        List<Hospital> hospitals = reader.readLines(readFilename);

        createFile(saveFilename);
        writeFile(hospitals, saveFilename);
    }
}
