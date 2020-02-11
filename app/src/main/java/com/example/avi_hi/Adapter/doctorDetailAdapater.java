package com.example.avi_hi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avi_hi.PojoClasses.DoctorPostPojo;
import com.example.avi_hi.R;

import java.util.ArrayList;
import java.util.List;

public class doctorDetailAdapater extends RecyclerView.Adapter<doctorDetailAdapater.ViewHolder> implements Filterable {

    private Context context;
    private ArrayList<DoctorPostPojo> doctorPostPojos;
    private ArrayList<DoctorPostPojo> doctorPostPojosfull;
    private OnItemClickListener mListener;



    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }

    public doctorDetailAdapater(Context context, ArrayList<DoctorPostPojo> doctorPostPojos) {
        this.context = context;
        this.doctorPostPojos = doctorPostPojos;
        doctorPostPojosfull = new ArrayList<>(doctorPostPojos);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_list_item,parent,false);
        return new doctorDetailAdapater.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(doctorPostPojos.get(position).getDoctor());
        holder.address.setText(doctorPostPojos.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return doctorPostPojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

         TextView name,address;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.doctor_name_card);
            address = itemView.findViewById(R.id.address_card);

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

    @Override
    public Filter getFilter() {
        return doctorFilter;
    }

    private Filter doctorFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<DoctorPostPojo> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(doctorPostPojosfull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (DoctorPostPojo item : doctorPostPojosfull) {
                    if (item.getDoctor().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            doctorPostPojos.clear();
            doctorPostPojos.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
