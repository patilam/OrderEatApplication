package com.example.amitm.ordereatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.amitm.ordereatapp.ViewHolder.OrderDetailAdapter;
import com.example.amitm.ordereatapp.model.Common;

public class ViewOrderDetails extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    String orderId="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order_details);

        recyclerView=(RecyclerView)findViewById(R.id.listOrderDetails);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        orderId=getIntent().getStringExtra("orderId");

        if(getIntent()!=null)
        {
            orderId=getIntent().getStringExtra("orderId");
        }
        OrderDetailAdapter adapter=new OrderDetailAdapter(Common.currentRequest.getFoods());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent viewOrdersIntent=new Intent(ViewOrderDetails.this,OrderStatus.class);
        startActivity(viewOrdersIntent);
    }
}

