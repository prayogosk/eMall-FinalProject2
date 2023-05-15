package com.prayogosk.finalproject2_kelompok4.staff;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.prayogosk.finalproject2_kelompok4.R;

public class StaffPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_page);
        Bundle bundle = getIntent().getExtras();

        TextView tvStaffName = findViewById(R.id.staff_name);
        tvStaffName.setText(bundle.getString("KEY_STAFF_USERNAME"));
    }
}
