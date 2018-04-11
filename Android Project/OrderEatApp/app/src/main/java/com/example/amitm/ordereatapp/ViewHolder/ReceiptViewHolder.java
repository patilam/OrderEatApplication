package com.example.amitm.ordereatapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.amitm.ordereatapp.R;

/**
 * Created by amitm on 4/11/2018.
 */

public class ReceiptViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtOrderId,txtOrderStatus,txtOrderPhone,txtOrderAddress,txtFood,txtTax,txtGratuity,txtOrderPrice;

    public ReceiptViewHolder(View itemView) {
        super(itemView);
        txtOrderAddress=(TextView)itemView.findViewById(R.id.order_address);
        txtOrderId=(TextView)itemView.findViewById(R.id.order_id);
        txtOrderPhone=(TextView)itemView.findViewById(R.id.order_phone);
        txtOrderPrice=(TextView)itemView.findViewById(R.id.order_total_price);
        txtFood=(TextView)itemView.findViewById(R.id.order_food);
        txtTax=(TextView)itemView.findViewById(R.id.tax_amount);
        txtGratuity=(TextView)itemView.findViewById(R.id.gratuity_amount);
    }

    @Override
    public void onClick(View v) {

    }
}
