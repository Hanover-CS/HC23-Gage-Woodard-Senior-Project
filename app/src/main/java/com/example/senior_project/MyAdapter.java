package com.example.senior_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList day_id, lift1_id, lift2_id, lift3_id, lift4_id, lift5_id;

    public MyAdapter(Context context, ArrayList day_id, ArrayList lift1_id, ArrayList lift2_id, ArrayList lift3_id, ArrayList lift4_id, ArrayList lift5_id) {
        this.context = context;
        this.day_id = day_id;
        this.lift1_id = lift1_id;
        this.lift2_id = lift2_id;
        this.lift3_id = lift3_id;
        this.lift4_id = lift4_id;
        this.lift5_id = lift5_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.day_id.setText(String.valueOf(day_id.get(position)));
        holder.lift1_id.setText(String.valueOf(lift1_id.get(position)));
        holder.lift2_id.setText(String.valueOf(lift2_id.get(position)));
        holder.lift3_id.setText(String.valueOf(lift3_id.get(position)));
        holder.lift4_id.setText(String.valueOf(lift4_id.get(position)));
        holder.lift5_id.setText(String.valueOf(lift5_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return day_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView day_id, lift1_id, lift2_id, lift3_id, lift4_id, lift5_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            day_id = itemView.findViewById(R.id.dayName);
            lift1_id = itemView.findViewById(R.id.lift1Name);
            lift2_id = itemView.findViewById(R.id.lift2Name);
            lift3_id = itemView.findViewById(R.id.lift3Name);
            lift4_id = itemView.findViewById(R.id.lift4Name);
            lift5_id = itemView.findViewById(R.id.lift5Name);
        }
    }

}
