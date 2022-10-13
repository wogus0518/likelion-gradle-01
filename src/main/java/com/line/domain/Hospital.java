package com.line.domain;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private int emergencRoom;
    private String name;
    private String subdivision;

    public Hospital(String id, String address, String district, String category, int emergencRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.district = district;
        this.category = category;
        this.emergencRoom = emergencRoom;
        this.name = name;
        this.subdivision = subdivision;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getCategory() {
        return category;
    }

    public int getEmergencyRoom() {
        return emergencRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public String getSQL() {
        String result = "INSERT INTO `likelion-db`.`seoul_hospital`(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)" +
                " VALUES ('" + this.id + "','" + this.address + "','" + this.district + "','" + this.category + "','" + this.emergencRoom + "','" + this.name + "',";
        if (this.subdivision != null) {
            result += "'" + this.subdivision + "');";
        } else {
            result += "null);";
        }
        return result;
    }
}
