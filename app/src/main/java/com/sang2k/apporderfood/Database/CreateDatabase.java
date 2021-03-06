package com.sang2k.apporderfood.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDatabase extends SQLiteOpenHelper {
    public static String TB_NHANVIEN="NHANVIEN";
    public static String TB_MONAN="MONAN";
    public static String TB_LOAIMONAN="LOAIMONAN";
    public static String TB_BANAN="BANAN";
    public static String TB_GOIMON="GOIMON";
    public static String TB_CHITIETGOIMON="CHITIETGOIMON";

    public static String TB_NHANVIEN_MANV="MANV";
    public static String TB_NHANVIEN_TENDN="TENDN";
    public static String TB_NHANVIEN_MATKHAU="MATKHAU";
    public static String TB_NHANVIEN_GIOITINH="GIOITINH";
    public static String TB_NHANVIEN_NGAYSINH="NGAYSINH";
    public static String TB_NHANVIEN_CMND="CMND";

    public static String TB_MONAN_MAMON="MAMON";
    public static String TB_MONAN_TENMONAN="TENMONAN";
    public static String TB_MONAN_GIATIEN="GIATIEN";
    public static String TB_MONAN_MALOAI="MALOAI";

    public static String TB_LOAIMONAN_MALOAI="MALOAI";
    public static String TB_LOAIMONAN_TENLOAI="TENLOAI";

    public static String TB_BANAN_MABAN="MABAN";
    public static String TB_BANAN_TENBAN="TENBAN";
    public static String TB_BANAN_TINHTRANG="TINHTRANG";

    public static String TB_GOIMON_MAGOIMON="MAGOIMON";
    public static String TB_GOIMON_MANV="MANV";
    public static String TB_GOIMON_NGAYGOI="NGAYGOI";
    public static String TB_GOIMON_TINHTRANG="TINHTRANG";
    public static String TB_GOIMON_MABAN="MABAN";

    public static String TB_CHITIETGOIMON_MAGOIMON="MAGOIMON";
    public static String TB_CHITIETGOIMON_MAMONAN="MAMONAN";
    public static String TB_CHITIETGOIMON_SOLUONG="SOLUONG";

    public CreateDatabase(Context context){
        super(context,"OrderFood",null,6);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbNHANVIEN="CREATE TABLE "+TB_NHANVIEN+" ( "+TB_NHANVIEN_MANV +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +TB_NHANVIEN_TENDN + " TEXT, "+TB_NHANVIEN_MATKHAU+" TEXT, "+TB_NHANVIEN_GIOITINH +" TEXT, "+ TB_NHANVIEN_NGAYSINH +" TEXT, "
                +TB_NHANVIEN_CMND + " TEXT)";

        String tbBANAN="CREATE TABLE "+TB_BANAN + " ( "+TB_BANAN_MABAN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +TB_BANAN_TENBAN + " TEXT, "+ TB_BANAN_TINHTRANG + " TEXT )";

        String tbMONAN="CREATE TABLE "+TB_MONAN + " ( "+TB_MONAN_MAMON + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +TB_MONAN_TENMONAN +" TEXT, "+TB_MONAN_MALOAI +" INTEGER, "+ TB_MONAN_GIATIEN+" TEXT )";

        String tbLOAIMONAN="CREATE TABLE "+TB_LOAIMONAN+ " ( "+TB_LOAIMONAN_MALOAI + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +TB_LOAIMONAN_TENLOAI +" TEXT )";

        String tbGOIMON="CREATE TABLE "+ TB_GOIMON +" ( "+TB_GOIMON_MAGOIMON + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +TB_GOIMON_MABAN + " INTEGER, "+TB_GOIMON_MANV + " INTEGER, "+ TB_GOIMON_NGAYGOI +" TEXT, "
                +TB_GOIMON_TINHTRANG +" TEXT )";

        String tbCHITIETGOIMON="CREATE TABLE "+TB_CHITIETGOIMON+ " ( "+TB_CHITIETGOIMON_MAGOIMON +" INTEGER, "
                + TB_CHITIETGOIMON_MAMONAN +" INTEGER, "+ TB_CHITIETGOIMON_SOLUONG+ " INTEGER, "
                +" PRIMARY KEY ( "+TB_CHITIETGOIMON_MAGOIMON +","+TB_CHITIETGOIMON_MAMONAN+"))";
        db.execSQL(tbNHANVIEN);
        db.execSQL(tbBANAN);
        db.execSQL(tbMONAN);
        db.execSQL(tbLOAIMONAN);
        db.execSQL(tbGOIMON);
        db.execSQL(tbCHITIETGOIMON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
