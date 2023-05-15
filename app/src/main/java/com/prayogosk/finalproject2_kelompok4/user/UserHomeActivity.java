package com.prayogosk.finalproject2_kelompok4.user;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.prayogosk.finalproject2_kelompok4.R;
import com.prayogosk.finalproject2_kelompok4.SQLiteDatabaseHandler;
import com.prayogosk.finalproject2_kelompok4.product.Product;
import com.prayogosk.finalproject2_kelompok4.product.ProductListActivity;
import com.prayogosk.finalproject2_kelompok4.product.ProductListAdapter;

import java.util.ArrayList;

public class UserHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        Button btnToProductClothing = findViewById(R.id.btn_type_clothing);
        Button btnToProductElectronic = findViewById(R.id.btn_type_electronic);
        Button btnToProductBooks = findViewById(R.id.btn_type_books);
        Button btnToProductOther = findViewById(R.id.btn_type_other);
        btnToProductClothing.setOnClickListener(view-> {
            Intent intent = new Intent(UserHomeActivity.this, ProductListActivity.class);
            intent.putExtra("KEY_PRODUCT_TYPE", "Clothing");
            startActivity(intent);
        });
        btnToProductElectronic.setOnClickListener(view-> {
            Intent intent = new Intent(UserHomeActivity.this, ProductListActivity.class);
            intent.putExtra("KEY_PRODUCT_TYPE", "Electronic");
            startActivity(intent);
        });
        btnToProductBooks.setOnClickListener(view-> {
            Intent intent = new Intent(UserHomeActivity.this, ProductListActivity.class);
            intent.putExtra("KEY_PRODUCT_TYPE", "Book");
            startActivity(intent);
        });
        btnToProductOther.setOnClickListener(view-> {
            Intent intent = new Intent(UserHomeActivity.this, ProductListActivity.class);
            intent.putExtra("KEY_PRODUCT_TYPE", "Other");
            startActivity(intent);
        });
    }
}
