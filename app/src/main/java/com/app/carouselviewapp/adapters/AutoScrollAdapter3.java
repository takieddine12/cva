package com.app.carouselviewapp.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.app.carouselviewapp.R;
import com.app.carouselviewapp.models.ScrollModel;

import java.util.ArrayList;

public class AutoScrollAdapter3 extends RecyclerView.Adapter<AutoScrollAdapter3.ViewHolder> {

    private final ArrayList<ScrollModel> arrayList;

    public AutoScrollAdapter3(ArrayList<ScrollModel> arrayList){
        this.arrayList  = arrayList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;
        private final ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewTitle);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.auto_scroll_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ScrollModel model = arrayList.get(position);
        holder.textView.setText(model.getTitle());
        holder.imageView.setImageResource(model.getDrawable());

        holder.imageView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("url",model.getUrl());
            Navigation.findNavController(holder.itemView).navigate(R.id.action_homeFragment_to_webFragment,bundle);
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void addData(ArrayList<ScrollModel> items){
        items.addAll(arrayList);
    }

}

