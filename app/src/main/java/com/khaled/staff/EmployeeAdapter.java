package com.khaled.staff;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private Context mContext; // Add this field

    private ArrayList<Employee> employees = new ArrayList<>();
    Button editBtn;

    public EmployeeAdapter(Context context) {
        mContext = context;
    }
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
        ViewHolder viewHolder = new ViewHolder(view);
        Button editBtn = view.findViewById(R.id.edit_btn);
        editBtn.setOnClickListener(v -> {
            int position = viewHolder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Employee employee = employees.get(position);
                Intent intent = new Intent(mContext, EditEmployeeActivity.class);
                intent.putExtra("employee_id", employee.getId());
                intent.putExtra("employee_name", employee.getName());
                intent.putExtra("employee_email", employee.getEmail());
                intent.putExtra("employee_phone", employee.getPhone());
                intent.putExtra("employee_gender", employee.getGender());
                mContext.startActivity(intent);
            }
        });
        return viewHolder;
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
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.employee_name);
        }
    }
}