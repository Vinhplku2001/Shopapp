package vinh.plk.vidu.recycleview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import vinh.plk.vidu.R;
import vinh.plk.vidu.data.ListProductDataShop;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {

    public interface OnItemClickListener {
        void onItemClick(int index);
    }

    OnItemClickListener listener;
    ArrayList<DataShop> dataShops;
    Context context;
    int totalAmount = 0 ;

    public CartAdapter(ArrayList<DataShop> dataShops,
                       Context context,
                       OnItemClickListener listener) {
        this.dataShops = dataShops;
        this.context = context;
        this.listener= listener;

    }

    public void updateAdapter(ArrayList<DataShop> mDataList) {
        this.dataShops = mDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from( parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.shopcart_item,parent, false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull  Viewholder holder,int position) {


//        totalAmount = totalAmount * dataShops.get(position).getGia();
        final DataShop dataShop_position = dataShops.get(position);
        Integer index =position;
//        String name = dataShops.get(position).getTen();
        Integer image = dataShops.get(position).getHinhanh();
        Integer price =dataShops.get(position).getGia();
        Integer amount= dataShops.get(position).getSoluong();

//        holder.name.setText(name);
        holder.amount.setText(amount +"kg");
        holder.price.setText("$"+price+"US");
        holder.image.setImageResource(image);

holder.delete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        listener.onItemClick(index);
//        Log.d("123", "m");
    }
});

    }

    @Override
    public int getItemCount() {
        return dataShops.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        ImageView image;
        TextView price;
        TextView amount;
        TextView total;
        Button  delete;
//        TextView priceNew;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById((R.id.name)) ;
            image=(ImageView) itemView.findViewById(R.id.hinhanh);
            price=(TextView ) itemView.findViewById(R.id.us);
            amount=(TextView) itemView.findViewById(R.id.soluong);
            total=(TextView) itemView.findViewById(R.id.total);
            delete=(Button)  itemView.findViewById(R.id.delete_cart);

        }

        @Override
        public void onClick(View view) {

        }

    }
}

