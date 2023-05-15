package com.prayogosk.finalproject2_kelompok4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.prayogosk.finalproject2_kelompok4.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {
    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int time = 3000;
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, StartPageActivity.class);
            startActivity(intent);
            finish();
        }, time);
    }
}
