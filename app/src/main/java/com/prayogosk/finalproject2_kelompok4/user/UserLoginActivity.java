package com.prayogosk.finalproject2_kelompok4.user;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.prayogosk.finalproject2_kelompok4.R;
import com.prayogosk.finalproject2_kelompok4.SQLiteDatabaseHandler;

import java.util.ArrayList;

public class UserLoginActivity extends AppCompatActivity {
    ArrayList<User> userList;
    SQLiteDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new SQLiteDatabaseHandler(this);
        setContentView(R.layout.activity_user_login);
        Button btnLogin = findViewById(R.id.btn_user_login);
        btnLogin.setOnClickListener(view -> {
            checkNull();
        });
    }

    private void checkNull() {
        EditText etUsername = findViewById(R.id.et_user_username);
        EditText etPassword = findViewById(R.id.et_user_password);
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
        userList = (ArrayList<User>) db.getAllUser();
        boolean loginSuccess = false;

        for (User user : userList) {
            if (username.equals(user.getName()) && password.equals(user.getPassword())) {
                Intent intent = new Intent(UserLoginActivity.this, UserHomeActivity.class);
                intent.putExtra("KEY_USER_USERNAME", user.getName());
                startActivity(intent);
                Toast.makeText(this, "Login As User", Toast.LENGTH_SHORT).show();
                loginSuccess = true;
                break;
            }
        }

        if (!loginSuccess) {
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }
    }
}

