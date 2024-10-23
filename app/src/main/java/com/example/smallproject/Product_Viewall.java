package com.example.smallproject;

import static android.app.PendingIntent.getActivity;
import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Product_Viewall extends AppCompatActivity implements ProductListener {

    RecyclerView rcyViewall;
    List<Product> productList = new ArrayList<>();
    Adapter_PdView adapter_pdView;
    Database_Handler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_viewall);

        rcyViewall = findViewById(R.id.prodtRc);

        databaseHandler = Database_Handler.getInstance(Product_Viewall.this);

        Intent intent = getIntent();
        productList = (List<Product>)intent.getSerializableExtra("product");


        adapter_pdView = new Adapter_PdView(productList, Product_Viewall.this,this);


        LinearLayoutManager managerList1 = new GridLayoutManager(Product_Viewall.this,2);
        rcyViewall.setLayoutManager(managerList1);
        rcyViewall.setAdapter(adapter_pdView);


    }

    @Override
    public void addToCart(Product product) {
        databaseHandler.addToCart(product);
        Log.d("AddCart: ","Item Added to cart");

    }

    @Override
    public void onClickItem(Product product) {

    }
}