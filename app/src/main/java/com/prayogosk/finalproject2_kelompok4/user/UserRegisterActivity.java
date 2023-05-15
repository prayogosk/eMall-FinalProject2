package com.prayogosk.finalproject2_kelompok4.user;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.prayogosk.finalproject2_kelompok4.R;
import com.prayogosk.finalproject2_kelompok4.SQLiteDatabaseHandler;

import java.util.ArrayList;

public class UserRegisterActivity extends AppCompatActivity {
    SQLiteDatabaseHandler db;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new SQLiteDatabaseHandler(this);
        setContentView(R.layout.activity_user_register);
        Button btnRegisteUser = findViewById(R.id.btn_user_register);
        btnRegisteUser.setOnClickListener(view -> {
            checkNull();
        });
    }

    private void checkNull() {
        EditText etUserName = findViewById(R.id.et_name);
        EditText etUserPassword = findViewById(R.id.et_password);
        EditText etUserConfirmPassword = findViewById(R.id.et_confirm_password);
        String userName = etUserName.getText().toString();
        String userPassword = etUserPassword.getText().toString();
        String userConfirmPassword = etUserConfirmPassword.getText().toString();
        if (userName.isEmpty()) {
            etUserName.setError("This field cannot be blank.");
        } else {
            etUserName.setError(null);
        }

        if (userPassword.isEmpty()) {
            etUserPassword.setError("This field cannot be blank.");
        } else {
            etUserPassword.setError(null);
        }

        if (!userConfirmPassword.equals(userPassword)) {
            etUserConfirmPassword.setError("The password confirmation does not match.");
        } else {
            etUserConfirmPassword.setError(null);
        }
        if (!userName.isEmpty() && !userPassword.isEmpty() && userConfirmPassword.equals(userPassword)) {
            registerUser(userName, userPassword);
        }
    }

    private void registerUser(String userName, String userPassword) {
        User user = new User(userName, userPassword);
        db.addUser(user);
        Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show();

        finish();

        users = (ArrayList<User>) db.getAllUser();
        for (User users : users) {
            Log.e("Isi User", users.getName() + users.getPassword());
        }
    }
}

