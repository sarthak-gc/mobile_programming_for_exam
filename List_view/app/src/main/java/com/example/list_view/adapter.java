package com.example.list_view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class adapter extends RecyclerView.Adapter<adapter.holder> {
    String[] data;
    public adapter(){
       this.data =new String[] {
               "hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi",
               "hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi",
               "hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi","hi",
       };
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.getTextView().setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class holder extends RecyclerView.ViewHolder{
        private final TextView language;
       public holder(@NonNull View itemView){
           super(itemView);
           language = itemView.findViewById(R.id.language);
       }
       public TextView getTextView(){
          return language;
       }
    }
}
