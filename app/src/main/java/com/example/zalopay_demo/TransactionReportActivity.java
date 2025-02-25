package com.example.zalopay_demo;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TransactionReportActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TransactionAdapter adapter;
    private List<Transaction> transactionList;
    private Button btnDatePicker;
    private Spinner spinnerStatus;
    private TextView tvTotalRevenue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_transaction_report);
        recyclerView = findViewById(R.id.recyclerView);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        spinnerStatus = findViewById(R.id.spinnerStatus);
        tvTotalRevenue = findViewById(R.id.tvTotalRevenue);

        transactionList = new ArrayList<>();
        transactionList.add(new Transaction("1", "2024-02-24", "Thành công", 50000));
        transactionList.add(new Transaction("2", "2024-02-23", "Thất bại", 20000));
        transactionList.add(new Transaction("3", "2024-02-22", "Thành công", 100000));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TransactionAdapter(transactionList);
        recyclerView.setAdapter(adapter);

        btnDatePicker.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
                String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        });
    }
}