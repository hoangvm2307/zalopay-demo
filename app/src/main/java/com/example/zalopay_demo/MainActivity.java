package com.example.zalopay_demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnConfirm;
    EditText etSoLuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConfirm = findViewById(R.id.btnConfirm);
        etSoLuong = findViewById(R.id.etSoLuong);

        btnConfirm.setOnClickListener(v -> {
            String soLuong = etSoLuong.getText().toString();
            if (soLuong.isEmpty()) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập số lượng", Toast.LENGTH_SHORT).show();
            }else{
                String soLuongString = etSoLuong.getText().toString();
                double total = Double.parseDouble(soLuongString) * (double) 1000;

                Intent intent = new Intent(MainActivity.this, OrderPayment.class);
                intent.putExtra("soluong", etSoLuong.getText().toString());
                intent.putExtra("total", total);
                startActivity(intent);
            }


        });
    }
}