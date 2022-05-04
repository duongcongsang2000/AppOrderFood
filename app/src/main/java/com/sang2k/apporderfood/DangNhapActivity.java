package com.sang2k.apporderfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sang2k.apporderfood.Dao.NhanVienDAO;

public class DangNhapActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDongy,btnDangkyDn;
    EditText edTendangnhap,edMatkhau;
    NhanVienDAO nhanVienDAO;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangnhap);
        btnDangkyDn=(Button) findViewById(R.id.btnDangkydn);
        btnDongy=(Button) findViewById(R.id.btnDongyDN);
        edTendangnhap=(EditText) findViewById(R.id.edtenDK);
        edMatkhau=(EditText) findViewById(R.id.edmatkhauDN);
        nhanVienDAO=new NhanVienDAO(this);
        btnDongy.setOnClickListener(this);
        btnDangkyDn.setOnClickListener(this);
        HienthiButton();
    }
    private void HienthiButton(){
        boolean kiemtra = nhanVienDAO.KiemtraNV();
        if (kiemtra)
        {
            btnDangkyDn.setVisibility(View.GONE);
            btnDongy.setVisibility(View.VISIBLE);
        }
        else
        {
            btnDangkyDn.setVisibility(View.VISIBLE);
            btnDongy.setVisibility(View.GONE);
        }
    }
    private void btnDongY(){
        String tendn=edTendangnhap.getText().toString();
        String pass=edMatkhau.getText().toString();
        boolean kt= nhanVienDAO.kiemtraDangNhap(tendn,pass);
        if (kt) Toast.makeText(DangNhapActivity.this,"Đăng Nhập Thành Công",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(DangNhapActivity.this,"Đăng Nhập Thất Bại",Toast.LENGTH_SHORT).show();
    }
    private void btnDangky(){
        Intent intentDk=new Intent(DangNhapActivity.this,DangKyActivity.class);
        startActivity(intentDk);
    }

    @Override
    protected void onResume() {
        super.onResume();
        HienthiButton();
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.btnDangkydn:
                btnDangky();
                ;break;
            case R.id.btnDongyDN:
                btnDongY();
                ;break;
        }
    }
}
