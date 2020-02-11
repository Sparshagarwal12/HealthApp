package com.example.avi_hi.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avi_hi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Surgery_CheckboxAdapter extends RecyclerView.Adapter<Surgery_CheckboxAdapter.CheckboxViewHolder> {

    private Context mCtx;
    private List<String> checkList;

    View view;

    FirebaseDatabase mAuth;

    public Surgery_CheckboxAdapter(Context mCtx, List<String> checkList) {
        this.mCtx = mCtx;
        this.checkList = checkList;
    }

    @NonNull
    @Override
    public CheckboxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        view = inflater.inflate(R.layout.surgery_checkbox, null);
        return new CheckboxViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CheckboxViewHolder holder, int position) {
        final String text = checkList.get(position);
        final List<CheckBox> checkboxList = new ArrayList<>();

        for(String s : checkList) {
            CheckBox cb = new CheckBox(mCtx);
            cb.setText(s);
//            cb.setChecked(true);
            holder.linearLayout.addView(cb);
            checkboxList.add(cb);
        }


        holder.addBtn_surgery.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater = LayoutInflater.from(mCtx);
                View promptView = layoutInflater.inflate(R.layout.prompts, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mCtx);
                alertDialogBuilder.setView(promptView);

                final EditText input = promptView.findViewById(R.id.userInput);

                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                CheckBox cb = new CheckBox(mCtx);
                                cb.setText(input.getText().toString());
//                                  cb.setChecked(true);
                                holder.linearLayout.addView(cb);
                                checkboxList.add(cb);

                            }
                        })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                AlertDialog alertD = alertDialogBuilder.create();
                alertD.show();
            }
        });

        holder.submit_surgery.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> items = new ArrayList<>();
                for (CheckBox item : checkboxList){
                    if(item.isChecked()) {
                        items.add(item.getText().toString());
                    }
                    for(final String checkedItem : items){
                        FirebaseDatabase.getInstance().getReference("Checkbox/"+checkedItem)
                                .setValue("Available").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(mCtx.getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    //display a failure message
                                    Toast.makeText(mCtx.getApplicationContext(), "Already have an Account", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });
    }
    @Override
    public int getItemCount() {
//            return checkList.size();
        return 1;
    }
    class CheckboxViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        Button submit_surgery;
        Button addBtn_surgery;

        public CheckboxViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout  = itemView.findViewById(R.id.surgery_layout);
            addBtn_surgery = itemView.findViewById(R.id.addBtn_surgery);
            submit_surgery= itemView.findViewById(R.id.submit_surgery);
        }
    }
}
