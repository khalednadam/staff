package com.khaled.staff;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private EmployeeAdapter adapter;
    private List<Employee> employeeList;
    FloatingActionButton addNewEmployeeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        addNewEmployeeBtn = findViewById(R.id.add_new_employee_btn);
        addNewEmployeeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddEmployeeActivity.class);
            startActivity(intent);
        });
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0D7EF4"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);

        recycler = findViewById(R.id.recycler);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Khaled Nadam", "software engineer", "+905055555", "jgaked", "male", "df"));
        employees.add(new Employee("Tahsin Nadam", "software engineer", "+905055555", "jgaked", "male", "df"));
        employees.add(new Employee("Fouaad Nadam", "software engineer", "+905055555", "jgaked", "male", "df"));
        employees.add(new Employee("Ahmad Nadam", "software engineer", "+905055555", "jgaked", "male", "df"));
        employees.add(new Employee("Khaled Nadam", "software engineer", "+905055555", "jgaked", "male", "df"));
        employees.add(new Employee("Tahsin Nadam", "software engineer", "+905055555", "jgaked", "male", "df"));
        employees.add(new Employee("Fouaad Nadam", "software engineer", "+905055555", "jgaked", "male", "df"));
        employees.add(new Employee("Ahmad Nadam", "software engineer", "+905055555", "jgaked", "male", "df"));
        EmployeeAdapter adapter1 = new EmployeeAdapter();
        adapter1.setEmployees(employees);

        recycler.setAdapter(adapter1);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) menuItem.getActionView();
        assert searchView != null;
        searchView.setQueryHint("Search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

        });
            return super.onCreateOptionsMenu(menu);
    }
}
