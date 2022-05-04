package com.sang2k.apporderfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sang2k.apporderfood.DTO.NhanVienDTO;
import com.sang2k.apporderfood.Dao.NhanVienDAO;
import com.sang2k.apporderfood.Database.CreateDatabase;
import com.sang2k.apporderfood.FragmentApp.DatePickerFragment;

public class DangKyActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    EditText tendangnhapdk,matkhaudk,edtngaysinhdk,cmnddk;
    Button btnDongYdk,btnThoatdk;
    RadioGroup grGioitinh;
    String gioitinh;
    NhanVienDAO nhanviendao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangky);
        tendangnhapdk=findViewById(R.id.tendk);
        matkhaudk=findViewById(R.id.matkhaudk);
        edtngaysinhdk=findViewById(R.id.ngaysinhdk);
        cmnddk=findViewById(R.id.cmnddk);
        btnDongYdk=findViewById(R.id.dongydk);
        btnThoatdk=findViewById(R.id.thoatdk);
        grGioitinh=findViewById(R.id.grgioitinhdk);

        edtngaysinhdk.setOnFocusChangeListener(this);
        btnDongYdk.setOnClickListener(this);
        btnThoatdk.setOnClickListener(this);
        nhanviendao=new NhanVienDAO(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.dongydk:
                String tendangnhap=tendangnhapdk.getText().toString();
                String matkhau=matkhaudk.getText().toString();
                switch (grGioitinh.getCheckedRadioButtonId())
                {
                    case R.id.rdbNam:
                        gioitinh="Nam";
                        break;
                    case R.id.rdbNu:
                        gioitinh="Nữ";
                        break;
                }
                String ngaysinh=edtngaysinhdk.getText().toString();
                String edtcmmd=cmnddk.getText().toString();
                if (tendangnhap==null || tendangnhap=="")
                    Toast.makeText(DangKyActivity.this,getResources().getString(R.string.thongbao1),Toast.LENGTH_LONG).show();
                else if (matkhau==null || matkhau=="")
                    Toast.makeText(DangKyActivity.this,getResources().getString(R.string.thongbao2),Toast.LENGTH_LONG).show();
                else
                {
                    NhanVienDTO nhanvien=new NhanVienDTO();
                    nhanvien.setTENDN(tendangnhap);
                    nhanvien.setMATKHAU(matkhau);
                    nhanvien.setCMND(edtcmmd);
                    nhanvien.setNGAYSINH(ngaysinh);
                    nhanvien.setGIOITINH(gioitinh);
                    long kiemtra =nhanviendao.ThemNV(nhanvien);
                    if (kiemtra!=0)
                        Toast.makeText(DangKyActivity.this,"Thêm Thành Công",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DangKyActivity.this,"Thêm Thất Bại",Toast.LENGTH_SHORT).show();

                }
                ;break;
            case R.id.thoatdk:
                finish();break;
        }
    }

    @Override
    public void onFocusChange(View view, boolean hasfocus) {
        int id=view.getId();
        switch (id) {
            case R.id.ngaysinhdk:
                if (hasfocus) {
                    DatePickerFragment datee=new DatePickerFragment();
                    datee.show(getSupportFragmentManager(),"haizzz");
                }
                ;break;
        }
    }

}