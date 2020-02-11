package com.example.avi_hi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avi_hi.R;
import com.example.avi_hi.PojoClasses.hospital_show_pojo;

import java.util.ArrayList;

public class HospitalGetAdapter extends RecyclerView.Adapter<HospitalGetAdapter.ViewHolder> {

    private Context context;
    private ArrayList<hospital_show_pojo> hospitalpojo;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }

    public HospitalGetAdapter(Context context, ArrayList<hospital_show_pojo> hospitalpojo) {
        this.context = context;
        this.hospitalpojo = hospitalpojo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_list_item,parent,false);
        return new HospitalGetAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(hospitalpojo.get(position).getName());
        holder.address.setText(hospitalpojo.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return hospitalpojo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name,address;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int position =getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
