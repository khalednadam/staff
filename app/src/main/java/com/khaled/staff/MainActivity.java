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
        employees.add(new Employee("1", "Khaled Nadam", "software engineer", "+905055555", "jgaked", "Male", "df"));
        employees.add(new Employee("2", "Lena Smith", "data analyst", "+901234567", "lsmith", "Female", "gh"));
        employees.add(new Employee("3", "John Doe", "project manager", "+902345678", "jdoe", "Male", "ij"));
        employees.add(new Employee("4", "Emily Johnson", "UX designer", "+903456789", "ejohnson", "Female", "kl"));
        employees.add(new Employee("5", "Ahmed Hassan", "systems administrator", "+904567890", "ahassan", "Male", "mn"));
        employees.add(new Employee("6", "Sophia Garcia", "software developer", "+905678901", "sgarcia", "Female", "op"));
        employees.add(new Employee("7", "Michael Brown", "network engineer", "+906789012", "mbrown", "Male", "qr"));
        employees.add(new Employee("8", "Emma Martinez", "database administrator", "+907890123", "emartinez", "Female", "st"));
        employees.add(new Employee("9", "Mohammed Khan", "frontend developer", "+908901234", "mkhan", "Male", "uv"));
        employees.add(new Employee("10", "Olivia Lopez", "backend developer", "+909012345", "olopez", "Female", "wx"));
        employees.add(new Employee("11", "William Taylor", "security analyst", "+901112345", "wtaylor", "Male", "yz"));
        employees.add(new Employee("12", "Ava Rodriguez", "software engineer", "+902223456", "arodriguez", "Female", "ab"));
        employees.add(new Employee("13", "James Wilson", "data scientist", "+903334567", "jwilson", "Male", "cd"));
        employees.add(new Employee("14", "Isabella Lee", "UI designer", "+904445678", "ilee", "Female", "ef"));
        employees.add(new Employee("15", "Daniel Young", "DevOps engineer", "+905556789", "dyoung", "Male", "gh"));
        employees.add(new Employee("16", "Mia Clark", "software developer", "+906667890", "mclark", "Female", "ij"));
        employees.add(new Employee("17", "Alexander Hernandez", "backend developer", "+907778901", "ahernandez", "Male", "kl"));
        employees.add(new Employee("18", "Ella Lewis", "network administrator", "+908889012", "elewis", "Female", "mn"));
        employees.add(new Employee("19", "Matthew Walker", "systems analyst", "+909990123", "mwalker", "Male", "op"));
        employees.add(new Employee("20", "Scarlett Hall", "frontend developer", "+900001234", "shall", "Female", "qr"));
        employees.add(new Employee("21", "Amelia Baker", "software engineer", "+901112345", "abaker", "Female", "st"));
        employees.add(new Employee("22", "Jacob Hill", "database administrator", "+902223456", "jhill", "Male", "uv"));
        employees.add(new Employee("23", "Charlotte Ward", "IT support specialist", "+903334567", "cward", "Female", "wx"));
        employees.add(new Employee("24", "Benjamin Morris", "software developer", "+904445678", "bmorris", "Male", "yz"));
        employees.add(new Employee("25", "Aria Nelson", "QA engineer", "+905556789", "anelson", "Female", "ab"));
        employees.add(new Employee("26", "Logan Rivera", "backend developer", "+906667890", "lrivera", "Male", "cd"));
        employees.add(new Employee("27", "Grace Adams", "software engineer", "+907778901", "gadams", "Female", "ef"));
        employees.add(new Employee("28", "Lucas Baker", "data analyst", "+908889012", "lbaker", "Male", "gh"));
        employees.add(new Employee("29", "Chloe Campbell", "UX designer", "+909990123", "ccampbell", "Female", "ij"));
        employees.add(new Employee("30", "Ethan Carter", "software developer", "+900001234", "ecarter", "Male", "kl"));
        EmployeeAdapter adapter1 = new EmployeeAdapter(this);
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

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
