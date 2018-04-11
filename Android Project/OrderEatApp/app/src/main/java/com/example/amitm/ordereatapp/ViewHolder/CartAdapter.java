package com.example.amitm.ordereatapp.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.amitm.ordereatapp.Interface.ItemClickListener;
import com.example.amitm.ordereatapp.R;
import com.example.amitm.ordereatapp.model.Common;
import com.example.amitm.ordereatapp.model.Order;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by amitm on 4/7/2018.
 */

class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener{

    public TextView txt_cart_name,txt_cart_price;
    public ImageView img_cart_count;

    private ItemClickListener itemClickListener;
//
//    public ItemClickListener getItemClickListener() {
//        return itemClickListener;
//    }
//
//    public void setItemClickListener(ItemClickListener itemClickListener) {
//        this.itemClickListener = itemClickListener;
//    }

    public CartViewHolder(View itemView) {
        super(itemView);
        txt_cart_name=(TextView)itemView.findViewById(R.id.cart_item_name);
        txt_cart_price=(TextView)itemView.findViewById(R.id.cart_item_price);
        img_cart_count=(ImageView)itemView.findViewById(R.id.cart_item_count);

        itemView.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select Action");
        menu.add(0,0,getAdapterPosition(), Common.DELETE);
    }
}

 public class CartAdapter extends RecyclerView.Adapter<CartViewHolder>{

    private List<Order> listData=new ArrayList<>();
    private Context context;

     public CartAdapter(List<Order> listData, Context context) {
         this.listData = listData;
         this.context = context;
     }

     @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         LayoutInflater inflater=LayoutInflater.from(context);
         View itemView=inflater.inflate(R.layout.cart_layout,parent,false);
         return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {

        TextDrawable textDrawable=TextDrawable.builder().buildRound(""+listData.get(position).getQuantity(), Color.RED);

        holder.img_cart_count.setImageDrawable(textDrawable);

        Locale locale=new Locale("en","US");

        NumberFormat fmt=NumberFormat.getCurrencyInstance(locale);
        double price=(Double.parseDouble(listData.get(position).getPrice()))*(Double.parseDouble(listData.get(position).getQuantity()));
        holder.txt_cart_price.setText(fmt.format(price));
        holder.txt_cart_name.setText(listData.get(position).getProductName());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
