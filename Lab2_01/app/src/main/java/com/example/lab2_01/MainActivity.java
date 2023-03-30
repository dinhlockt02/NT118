package com.example.lab2_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lab2_01.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EmployeeAdapter adapter;

    ListView employeeLv;
    Button addBtn;
    EditText idEt;
    EditText fullnameEt;
    CheckBox isManagerCkb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        List<Employee> employees = new ArrayList<Employee>();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn = (Button) findViewById(R.id.btn_add_new_employee);
        employeeLv = (ListView) findViewById(R.id.lv_employee);
        idEt = (EditText) findViewById(R.id.et_new_eployee_id);
        fullnameEt = (EditText) findViewById(R.id.et_new_eployee_name);
        isManagerCkb = (CheckBox) findViewById(R.id.ckb_new_eployee_isManager);


        adapter = new EmployeeAdapter(this, R.layout.item_employee, employees);
        employeeLv.setAdapter(adapter);


        addBtn.setOnClickListener((view) -> {
            Employee employee = new Employee(idEt.getText().toString(), fullnameEt.getText().toString(), isManagerCkb.isChecked());
            employees.add(employee);
            adapter.notifyDataSetChanged();
        });
    }
}