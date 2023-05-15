package com.prayogosk.finalproject2_kelompok4.product;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.prayogosk.finalproject2_kelompok4.R;
import com.prayogosk.finalproject2_kelompok4.SQLiteDatabaseHandler;

import java.util.ArrayList;

public class ProductListAdapter extends BaseAdapter {
    private Activity context;
    ArrayList<Product> products;
    SQLiteDatabaseHandler db;

    public ProductListAdapter(Activity context, ArrayList<Product> products, SQLiteDatabaseHandler db) {
        this.context = context;
        this.products = products;
        this.db = db;
    }

    public static class ViewHolder {
        ImageView ivUserProductImage;
        TextView tvUserProductName;
        TextView tvUserProductQuantity;
        TextView tvUserProductId;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        LayoutInflater inflater = context.getLayoutInflater();
        ViewHolder vh;
        if (view == null) {
            vh = new ViewHolder();
            row = inflater.inflate(R.layout.item_user_product, null, true);

            vh.ivUserProductImage = row.findViewById(R.id.iv_user_product_image);
            vh.tvUserProductName = row.findViewById(R.id.tv_user_product_name);
            vh.tvUserProductQuantity = row.findViewById(R.id.tv_user_product_quantity_amount);
            vh.tvUserProductId = row.findViewById(R.id.tv_user_product_id_content);

            row.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        vh.tvUserProductName.setText(products.get(position).getName());
        vh.tvUserProductQuantity.setText(String.valueOf(products.get(position).getQuantity()));
        vh.tvUserProductId.setText(String.valueOf(products.get(position).getId()));

        switch (products.get(position).getId()) {
            case 1:
                vh.ivUserProductImage.setImageResource(R.drawable.sweater);
                break;
            case 2:
                vh.ivUserProductImage.setImageResource(R.drawable.kemeja);
                break;
            case 3:
                vh.ivUserProductImage.setImageResource(R.drawable.jaket);
                break;
            case 4:
                vh.ivUserProductImage.setImageResource(R.drawable.jeans);
                break;
            case 5:
                vh.ivUserProductImage.setImageResource(R.drawable.iphone_14);
                break;
            case 6:
                vh.ivUserProductImage.setImageResource(R.drawable.macbook_pro_13);
                break;
            case 7:
                vh.ivUserProductImage.setImageResource(R.drawable.headphone_rexus_vonix);
                break;
            case 8:
                vh.ivUserProductImage.setImageResource(R.drawable.buku_androidkotlin);
                break;
            case 9:
                vh.ivUserProductImage.setImageResource(R.drawable.buku_web_dinamisphp);
                break;
            case 10:
                vh.ivUserProductImage.setImageResource(R.drawable.buku_androidstudio);
                break;
            case 11:
                vh.ivUserProductImage.setImageResource(R.drawable.set_alat_services);
                break;
        }
        return row;
    }
}
