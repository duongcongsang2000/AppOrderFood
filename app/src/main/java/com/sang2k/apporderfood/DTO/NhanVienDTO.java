package com.sang2k.apporderfood.DTO;

public class NhanVienDTO {
    int MANV;
    String TENDN,MATKHAU,GIOITINH,NGAYSINH,CMND;
    public int getMANV() {
        return MANV;
    }
    public void setMNV(int MNV) {
        this.MANV = MNV;
    }
    public String getCMND() {
        return CMND;
    }
    public void setCMND(String CMND) {
        this.CMND = CMND;
    }
    public String getTENDN() {
        return TENDN;
    }
    public void setTENDN(String TENDN) {
        this.TENDN = TENDN;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }
    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }
    public String getNGAYSINH() {
        return NGAYSINH;
    }
    public void setNGAYSINH(String NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }



}
