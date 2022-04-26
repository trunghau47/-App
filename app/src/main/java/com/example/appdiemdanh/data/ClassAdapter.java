package com.example.appdiemdanh.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdiemdanh.R;

import java.util.ArrayList;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> class_ID, class_Name , idGV;

    public ClassAdapter(Context context, ArrayList class_ID, ArrayList class_Name, ArrayList idGV){
        this.context = context;
        this.class_ID = class_ID;
        this.class_Name = class_Name;
        this.idGV = idGV;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_class,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtClassName.setText(String.valueOf(class_Name.get(position)));
        holder.idGV.setText(String.valueOf(idGV.get(position)));
    }

    @Override
    public int getItemCount() {
        return class_ID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtClassName,idGV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtClassName = itemView.findViewById(R.id.txtClassName);
            idGV = itemView.findViewById(R.id.idGV);
        }
    }
}
