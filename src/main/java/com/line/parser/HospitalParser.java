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
        int emergencyRoom = Integer.parseInt(splitted[6]);
        String name = splitted[10];
        String subdivision = getSubdivion(name);

        return new Hospital(id, address, district, category, emergencyRoom, name, subdivision);
    }

    private String getDistrict(String address) {
        String[] splitted = address.split(" ");
        return splitted[0] + " " + splitted[1];
    }

    private String getSubdivion(String name) {
        String[] subdivisionList = new String[]{"피부과", "소아과", "가정의학과", "치과", "안과", "산부인과", "비뇨기과"};

        for (int i = 0; i < subdivisionList.length; i++) {
            if (name.contains(subdivisionList[i])) {
                return subdivisionList[i];
            }
        }
        return null;
    }
}
