package com.prayogosk.finalproject2_kelompok4.product;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.prayogosk.finalproject2_kelompok4.R;
import com.prayogosk.finalproject2_kelompok4.SQLiteDatabaseHandler;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {
    SQLiteDatabaseHandler db;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new SQLiteDatabaseHandler(this);
        setContentView(R.layout.activity_product_list);
        ListView listView = findViewById(R.id.lv_user_product_list);

        Bundle bundle = getIntent().getExtras();
        products = (ArrayList<Product>) db.getProductByType(bundle.getString("KEY_PRODUCT_TYPE"));
        ProductListAdapter adapter = new ProductListAdapter(this, products, db);
        listView.setAdapter(adapter);
    }
}
