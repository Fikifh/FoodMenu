package com.fikisite.fiki.foodmenu;
import com.fikisite.fiki.foodmenu.R;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListFoodsAdapter extends RecyclerView.Adapter<ListFoodsAdapter.CategoryViewHolder> {
    private Context context;
    int clayout;



    public ArrayList<Foods> getListFoods() {
        return listFoods;
    }
    public void setListFoods(ArrayList<Foods> listFoods){
        this.listFoods = listFoods;
    }

    private ArrayList<Foods>listFoods;
    public ListFoodsAdapter(Context context, int clayout){
        this.context=context;
        this.clayout=clayout;
    }

    @NonNull
    @Override
    public ListFoodsAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_menu, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ListFoodsAdapter.CategoryViewHolder holder, final int position) {
        holder.tvName.setText(getListFoods().get(position).getName());
        holder.tvHarga.setText(getListFoods().get(position).getHarga());

        Glide.with(context)
                .load(getListFoods().get(position).getPhoto())
                .override(55, 55)
                .crossFade()
                .into(holder.imgPhoto);

        holder.clayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = getListFoods().get(position).getName();
                Intent moveIntent = new Intent(context, DetailMenuActivity.class);
                moveIntent.putExtra("nama", nama);
                moveIntent.putExtra("harga", getListFoods().get(position).getHarga());
                moveIntent.putExtra("photo", getListFoods().get(position).getPhoto());
                context.startActivity(moveIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListFoods().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvHarga;
        ImageView imgPhoto;
        RelativeLayout clayout;

        public CategoryViewHolder(View itemView){
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvHarga = (TextView)itemView.findViewById(R.id.tv_item_harga);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            clayout = itemView.findViewById(R.id.layout_adapter);

        }
    }
}
