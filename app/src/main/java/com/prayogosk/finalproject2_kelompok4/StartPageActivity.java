package com.prayogosk.finalproject2_kelompok4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.prayogosk.finalproject2_kelompok4.admin.AdminLoginActivity;
import com.prayogosk.finalproject2_kelompok4.staff.StaffLoginActivity;
import com.prayogosk.finalproject2_kelompok4.user.UserLoginActivity;
import com.prayogosk.finalproject2_kelompok4.user.UserRegisterActivity;

public class StartPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        TextView btnToLoginAdmin = findViewById(R.id.btn_to_login_admin);
        TextView btnToLoginStaff = findViewById(R.id.btn_to_login_staff);
        TextView btnToLoginUser = findViewById(R.id.btn_to_user_login);
        TextView btnToRegisterUser = findViewById(R.id.btn_to_user_register);

        btnToLoginAdmin.setOnClickListener(view -> {
            Intent intent = new Intent(StartPageActivity.this, AdminLoginActivity.class);
            startActivity(intent);
        });
        btnToLoginStaff.setOnClickListener(view -> {
            Intent intent = new Intent(StartPageActivity.this, StaffLoginActivity.class);
            startActivity(intent);
        });
        btnToLoginUser.setOnClickListener(view -> {
            Intent intent = new Intent(StartPageActivity.this, UserLoginActivity.class);
            startActivity(intent);
        });
        btnToRegisterUser.setOnClickListener(view -> {
            Intent intent = new Intent(StartPageActivity.this, UserRegisterActivity.class);
            startActivity(intent);
        });
    }
}
