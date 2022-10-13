package com.line.parser;

import com.line.domain.Hospital;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HospitalParser implements Parser<Hospital> {

    @Override
    public Hospital parse(String str) {
        String[] splitted = str.split(",");

        String id = splitted[0];
        String address = splitted[1];
        String district = getDistrict(address);
        String category = splitted[2];

        return new Hospital(id, address, district, category);
    }

    private String getDistrict(String address) {
        String[] splitted = address.split(" ");
        return splitted[0] + " " + splitted[1];
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
