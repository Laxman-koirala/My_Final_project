package com.example.scientificcalculator.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scientificcalculator.R;
import com.example.scientificcalculator.controller.ArrayController;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViewHolder> {
    private ArrayList<ArrayController> mArrayList;

    public MyAdapter(ArrayList<ArrayController> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_equation_design, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArrayController currentItem = mArrayList.get(position);
        holder.ResultEquation.setText(currentItem.getMyResult());

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ResultEquation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ResultEquation = itemView.findViewById(R.id.textView);
        }
    }
}
