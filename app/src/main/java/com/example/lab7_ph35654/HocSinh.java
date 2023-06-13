package com.example.lab7_ph35654;

import java.io.Serializable;

public class HocSinh implements Serializable {
    private String name;
    private  String idSV;
    private int Diem;

    public HocSinh(String name, String idSV, int diem) {
        this.name = name;
        this.idSV = idSV;
        Diem = diem;
    }

    public HocSinh() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdSV() {
        return idSV;
    }

    public void setIdSV(String idSV) {
        this.idSV = idSV;
    }

    public int getDiem() {
        return Diem;
    }

    public void setDiem(int diem) {
        Diem = diem;
    }
}
