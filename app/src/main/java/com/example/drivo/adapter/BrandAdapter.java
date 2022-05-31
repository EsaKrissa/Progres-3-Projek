package com.example.drivo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drivo.Mobil;
import com.example.drivo.R;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.ViewHolder> {

    String data1[], data2[];
    int brand_logo[];
    Context context;

    public BrandAdapter(Context ct, String s1[], String s2[], int blogo[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        brand_logo = blogo;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.brand_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namaBrand.setText(data1[position]);
        holder.modelBrand.setText(data2[position]);
        holder.brandLogo.setImageResource(brand_logo[position]);

        holder.brandLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, Mobil.class);
            intent.putExtra ("data1", data1[position]);
            intent.putExtra ("brandLogo", brand_logo[position]);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {

        return brand_logo.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView namaBrand, modelBrand;
        ImageView brandLogo;
        ConstraintLayout brandLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaBrand = itemView.findViewById(R.id.nama_brand);
            modelBrand = itemView.findViewById(R.id.model_brand);
            brandLogo = itemView.findViewById(R.id.brand_logo);
            brandLayout = itemView.findViewById(R.id.brandLayout);
        }
    }
}
