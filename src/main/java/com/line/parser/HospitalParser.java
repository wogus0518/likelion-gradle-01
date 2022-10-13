package com.line.parser;

import com.line.domain.Hospital;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HospitalParser implements Parser<Hospital> {
    @Override
    public Hospital parse(String str) {
        String[] info = str.split(",");

        String id = info[0];
        String address = info[1];

        return new Hospital(id, address);
    }


//    @Override
//    public Hospital parse(String str) {
//        String[] info = str.split(",");
//        if (info.length==6) {
//            return new Hospital(info[0], info[1], info[2], info[3], Integer.parseInt(info[4]), info[5], null);
//        }
//        return new Hospital(info[0], info[1], info[2], info[3], Integer.parseInt(info[4]), info[5], info[6]);
//    }
}
