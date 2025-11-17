package com.example.ngoduchiep2_cntt02;

public class Sach {
    private String masach, tensach, theloaisach, tacgia, nhaxuatban;
    private float dongia;
    public Sach() {

    }

    @Override
    public String toString() {
        return "Sach{" +
                "masach='" + masach + '\'' +
                ", tensach='" + tensach + '\'' +
                ", theloaisach='" + theloaisach + '\'' +
                ", tacgia='" + tacgia + '\'' +
                ", nhaxuatban='" + nhaxuatban + '\'' +
                ", dongia=" + dongia +
                '}';
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTheloaisach() {
        return theloaisach;
    }

    public void setTheloaisach(String theloaisach) {
        this.theloaisach = theloaisach;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNhaxuatban() {
        return nhaxuatban;
    }

    public void setNhaxuatban(String nhaxuatban) {
        this.nhaxuatban = nhaxuatban;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public Sach(String masach, String tensach, String theloaisach, String tacgia, String nhaxuatban, float dongia) {
        this.masach = masach;
        this.tensach = tensach;
        this.theloaisach = theloaisach;
        this.tacgia = tacgia;
        this.nhaxuatban = nhaxuatban;
        this.dongia = dongia;
    }

    public Sach(String masach) {
        this.masach = masach;
    }
}
