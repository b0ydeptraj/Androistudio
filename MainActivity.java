package com.example.ngoduchiep2_cntt02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtmasach, edttensach, edttheloaisach, edttacgia, edtnhaxuatban, edtdongia;
    Button btnThem, btnSua, btnXoa, btnThoat;
    ListView lvsach;
    SachAdapter adapter;
    List<Sach> listSach;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //B2: Ánh xạ
        anhxa();
        listSach = new ArrayList<>();

        setAdapter();
        //bắt sự kiện cho các button
        // Nút Thêm
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lấy dl từ các ô edittext
                String masach = edtmasach.getText().toString();
                String tensach = edttensach.getText().toString();
                String theloaisach = edttheloaisach.getText().toString();
                String tacgia = edttacgia.getText().toString();
                String nhaxuatban = edtnhaxuatban.getText().toString();
                float dongia = Float.parseFloat(edtdongia.getText().toString());

                listSach.add(new Sach(masach, tensach, theloaisach, tacgia, nhaxuatban, dongia));
                setAdapter();
            }
        });
        // Nút Sửa
        btnSua.setOnClickListener(v -> {
            if (index < 0) return;

            String masach = edtmasach.getText().toString();
            String tensach = edttensach.getText().toString();
            String theloaisach = edttheloaisach.getText().toString();
            String tacgia = edttacgia.getText().toString();
            String nhaxuatban = edtnhaxuatban.getText().toString();
            float dongia = Float.parseFloat(edtdongia.getText().toString());

            Sach sp = listSach.get(index);

            sp.setMasach(masach);
            sp.setTensach(tensach);
            sp.setTheloaisach(theloaisach);
            sp.setTacgia(tacgia);
            sp.setNhaxuatban(nhaxuatban);
            sp.setDongia(dongia);

            setAdapter();
            index = -1;
        });
        //Nút Xóa

        btnXoa.setOnClickListener(v -> {
            if (index < 0) return;

            listSach.remove(index);
            setAdapter();
            index = -1;
        });
        //Nút Thoát
        btnThoat.setOnClickListener(v -> finish());


    }

    private void anhxa() {
        edtmasach = findViewById(R.id.edt_masach);
        edttensach = findViewById(R.id.edt_tensach);
        edttheloaisach = findViewById(R.id.edt_theloaisach);
        edttacgia = findViewById(R.id.edt_tacgia);
        edtnhaxuatban = findViewById(R.id.edt_nhaxuatban);
        edtdongia = findViewById(R.id.edt_dongia);

        btnThem = findViewById(R.id.btn_Them);
        btnSua = findViewById(R.id.btn_Sua);
        btnXoa = findViewById(R.id.btn_Xoa);
        btnThoat = findViewById(R.id.btn_Thoat);

        lvsach = findViewById(R.id.lv_sach);
    }

    private void setAdapter() {
        if (adapter == null) {
            adapter = new SachAdapter(MainActivity.this,
                    R.layout.list_sach,
                    listSach);
            lvsach.setAdapter(adapter);
        }else{

            adapter.notifyDataSetChanged();
            edtmasach.setText("");
            edttensach.setText("");
            edttheloaisach.setText("");
            edttacgia.setText("");
            edtnhaxuatban.setText("");
            edtdongia.setText("");

        }
        lvsach.setOnItemClickListener((parent, view, position, id) -> {
            Sach sp = listSach.get(position);

            edtmasach.setText(sp.getMasach());
            edttensach.setText(sp.getTensach());
            edttheloaisach.setText(sp.getTheloaisach());
            edttacgia.setText(String.valueOf(sp.getTacgia()));
            edtnhaxuatban.setText(String.valueOf(sp.getNhaxuatban()));
            edtdongia.setText(String.valueOf(sp.getDongia()));


            index = position;
        });
    }
}