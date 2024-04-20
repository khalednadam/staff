package com.khaled.staff;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private ArrayList<Employee> employees = new ArrayList<>();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    public EmployeeAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(employees.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    //    private List<Employee> employeeList;
public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.employee_name);
        }
    }
}