package com.example.drivo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.drivo.adapter.BrandAdapter;
import com.example.drivo.fragment.HomeFragment;

public class Brand extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int brand_logo[] = {R.drawable.brand_logo_1, R.drawable.brand_logo_2, R.drawable.brand_logo_3, R.drawable.brand_logo_4, R.drawable.brand_logo_5,
            R.drawable.brand_logo_6, R.drawable.brand_logo_7, R.drawable.brand_logo_8, R.drawable.brand_logo_9, R.drawable.brand_logo_10,
            R.drawable.brand_logo_11, R.drawable.brand_logo_12, R.drawable.brand_logo_13, R.drawable.brand_logo_14, R.drawable.brand_logo_15,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);

        Button btnBack = findViewById(R.id.back_arrow_brand);

        recyclerView = findViewById(R.id.brand_recyclerview);

        s1 = getResources().getStringArray(R.array.nama_brand);
        s2 = getResources().getStringArray(R.array.deskripsi_brand);

        BrandAdapter brandAdapter = new BrandAdapter(this, s1, s2, brand_logo);
        recyclerView.setAdapter(brandAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        btnBack.setOnClickListener(v -> {

            Intent intent = new Intent(Brand.this, MainActivity.class);
            startActivity(intent);

        });

    }
}