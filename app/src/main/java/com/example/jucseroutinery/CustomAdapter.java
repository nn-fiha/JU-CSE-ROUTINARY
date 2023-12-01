package com.example.jucseroutinery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id, day,time1,time2, time3, time4;


    CustomAdapter(Context context,
                  ArrayList id,
                  ArrayList day,
                  ArrayList time1,
                  ArrayList time2,
                  ArrayList time3,
                  ArrayList time4){
        this.context = context;
        this.id = id;
        this.day = day;
        this.time1 = time1;
        this.time2 = time2;
        this.time3 = time3;
        this.time4 = time4;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.my_row, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.day.setText(String.valueOf(day.get(position)));
        holder.time1.setText(String.valueOf(time1.get(position)));
        holder.time2.setText(String.valueOf(time2.get(position)));
        holder.time3.setText(String.valueOf(time3.get(position)));
        holder.time4.setText(String.valueOf(time4.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,UpdateActivity.class);
                intent.putExtra("id1",String.valueOf(id.get(position)));
                intent.putExtra("day1",String.valueOf(day.get(position)));
                intent.putExtra("time11",String.valueOf(time1.get(position)));
                intent.putExtra("time21",String.valueOf(time2.get(position)));
                intent.putExtra("time31",String.valueOf(time3.get(position)));
                intent.putExtra("time41",String.valueOf(time4.get(position)));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id, day,time1, time2, time3, time4;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_txt);
            day = itemView.findViewById(R.id.day);
            time1 = itemView.findViewById(R.id.time1);
            time2 = itemView.findViewById(R.id.time2);
            time3 = itemView.findViewById(R.id.time3);
            time4 = itemView.findViewById(R.id.time4);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
