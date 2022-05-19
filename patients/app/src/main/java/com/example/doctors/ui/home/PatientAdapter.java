package com.example.doctors.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.doctors.dao.PatientDAO;
import com.example.doctors.databinding.ItemLayoutBinding;
import com.example.doctors.databinding.ItemPatientBinding;
import com.example.doctors.models.Patient;
import com.example.doctors.ui.room.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {
    private List<Patient> patients = new ArrayList<>();
    private PatientDAO patientDAO;

    public void setList(List<Patient> patients){
        this.patients = patients;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PatientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPatientBinding itemPatientBinding = ItemPatientBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ViewHolder viewHolder = new ViewHolder(itemPatientBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        patientDAO = Room.databaseBuilder(holder.binding.getRoot().getContext(), AppDatabase.class, "database").allowMainThreadQueries().build().patientDAO();
        Patient patient = patients.get(position);
        holder.binding.fName.setText(patient.getF_name());
        holder.binding.lName.setText(patient.getL_name());
        holder.binding.phone.setText(patient.getPhone());
        holder.binding.patientCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "очередь"+(holder.getAdapterPosition()+1), Toast.LENGTH_SHORT).show();
            }


        });
        holder.binding.patientCard.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(holder.binding.getRoot().getContext()).create();
                alertDialog.setTitle("Вы хотите удалиться с очереди?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Да",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                patientDAO.deletePatient(patient);
                                patients.remove(holder.getAdapterPosition());
                                notifyDataSetChanged();
                                dialog.dismiss();
                            }
                        });

                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Нет",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemPatientBinding binding;

        public ViewHolder(@NonNull ItemPatientBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

    }
}
