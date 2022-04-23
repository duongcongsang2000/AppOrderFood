package com.sang2k.apporderfood.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.sang2k.apporderfood.DTO.NhanVienDTO;
import com.sang2k.apporderfood.Database.CreateDatabase;

public class NhanVienDAO {
    SQLiteDatabase database;
    public NhanVienDAO (Context context){
        CreateDatabase db=new CreateDatabase(context);
        database=db.open();
    }
    public long ThemNV(NhanVienDTO nhanVienDTO){
        ContentValues contentValues=new ContentValues();
        contentValues.put(CreateDatabase.TB_NHANVIEN_TENDN,nhanVienDTO.getTENDN());
        contentValues.put(CreateDatabase.TB_NHANVIEN_CMND,nhanVienDTO.getCMND());
        contentValues.put(CreateDatabase.TB_NHANVIEN_GIOITINH,nhanVienDTO.getGIOITINH());
        contentValues.put(CreateDatabase.TB_NHANVIEN_MATKHAU,nhanVienDTO.getMATKHAU());
        contentValues.put(CreateDatabase.TB_NHANVIEN_NGAYSINH,nhanVienDTO.getNGAYSINH());
        long kiemtra=database.insert(CreateDatabase.TB_NHANVIEN,null,contentValues);
        return kiemtra;
    }
}
