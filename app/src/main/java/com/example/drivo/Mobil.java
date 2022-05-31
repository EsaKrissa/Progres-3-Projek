package com.example.drivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Mobil extends AppCompatActivity {

    ImageView brandImageView;
    TextView nama_brand;

    String data1;
    int brandLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobil);

        brandImageView = findViewById(R.id.main_brand_logo);
        nama_brand = findViewById(R.id.main_nama_brand);
        Button btnBack = findViewById(R.id.back_arrow_mobil);

        getData();
        setData();


        btnBack.setOnClickListener(v1 -> {
            Intent intent = new Intent(Mobil.this, Brand.class);
            startActivity(intent);
        });


    }

    private void getData(){
        if(getIntent().hasExtra("brandLogo") && getIntent().hasExtra("data1")){

            data1 = getIntent().getStringExtra("data1");
            brandLogo = getIntent().getIntExtra("brandLogo", 1);

        } else{
            Toast.makeText(this, "Tidak ada data", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData(){
        nama_brand.setText(data1);
        brandImageView.setImageResource(brandLogo);

    }

}