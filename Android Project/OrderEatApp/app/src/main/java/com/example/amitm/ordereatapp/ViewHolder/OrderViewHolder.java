package com.example.amitm.ordereatapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import com.example.amitm.ordereatapp.Interface.ItemClickListener;
import com.example.amitm.ordereatapp.R;
import com.example.amitm.ordereatapp.model.Common;

/**
 * Created by amitm on 4/7/2018.
 */

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener{
    public TextView txtOrderId,txtOrderStatus,txtOrderPhone,txtOrderAddress,txtOrderPrice;

    private ItemClickListener itemClickListener;

    public OrderViewHolder(View itemView) {
        super(itemView);
        txtOrderAddress=(TextView)itemView.findViewById(R.id.order_address);
        txtOrderId=(TextView)itemView.findViewById(R.id.order_id);
        txtOrderStatus=(TextView)itemView.findViewById(R.id.order_status);
        txtOrderPhone=(TextView)itemView.findViewById(R.id.order_phone);
        txtOrderPrice=(TextView)itemView.findViewById(R.id.order_total_price);
        itemView.setOnCreateContextMenuListener(this);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

      public OrderViewHolder(View itemView, ItemClickListener itemClickListener) {
          super(itemView);
          this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select an option:");
        menu.add(0,1,getAdapterPosition(),Common.CANCEL);
        menu.add(0,2,getAdapterPosition(),Common.EMAIL);
        menu.add(0,3,getAdapterPosition(),Common.ACCEPT);
    }
}
