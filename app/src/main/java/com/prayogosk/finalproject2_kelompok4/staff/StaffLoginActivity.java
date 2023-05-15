package com.prayogosk.finalproject2_kelompok4.staff;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.prayogosk.finalproject2_kelompok4.R;
import com.prayogosk.finalproject2_kelompok4.SQLiteDatabaseHandler;

import java.util.ArrayList;

public class StaffLoginActivity extends AppCompatActivity {
    ArrayList<Staff> staffList;
    SQLiteDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new SQLiteDatabaseHandler(this);
        setContentView(R.layout.activity_login_staff);
        Button btnLogin = findViewById(R.id.btn_staff_login);
        btnLogin.setOnClickListener(view -> {
            checkNull();
        });
    }

    private void checkNull() {
        EditText etUsername = findViewById(R.id.et_staff_username);
        EditText etPassword = findViewById(R.id.et_staff_password);
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (username.isEmpty()) {
            etUsername.setError("This field cannot be blank.");
        } else {
            etUsername.setError(null);
        }

        if (password.isEmpty()) {
            etPassword.setError("This field cannot be blank.");
        } else {
            etPassword.setError(null);
        }

        if (!username.isEmpty() && !password.isEmpty()) {
            loginAction(username, password);
        }
    }

    private void loginAction(String username, String password) {
        staffList = (ArrayList<Staff>) db.getAllStaff();
        boolean loginSuccess = false;

        for (Staff staff : staffList) {
            if (username.equals(staff.getName()) && password.equals(staff.getPassword())) {
                Intent intent = new Intent(StaffLoginActivity.this, StaffPageActivity.class);
                intent.putExtra("KEY_STAFF_USERNAME", staff.getName());
                startActivity(intent);
                Toast.makeText(this, "Login As Staff", Toast.LENGTH_SHORT).show();
                loginSuccess = true;
                break;
            }
        }

        if (!loginSuccess) {
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }
    }
}
