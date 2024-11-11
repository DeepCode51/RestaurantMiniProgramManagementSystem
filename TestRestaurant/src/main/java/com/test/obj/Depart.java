package com.test.obj;

public class Depart {
    private int id;
    private String sdepart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSdepart() {
        return sdepart;
    }

    public void setSdepart(String sdepart) {
        this.sdepart = sdepart;
    }

    @Override
    public String toString() {
        return "Depart{" +
                "id=" + id +
                ", sdepart='" + sdepart + '\'' +
                '}';
    }
}
