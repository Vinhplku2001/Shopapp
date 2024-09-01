package vinh.plk.vidu.recycleview;

import android.content.Context;
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

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.Viewholder> {

    public interface OnItemClickListener {
        void onItemClick(DataShop item);
    }

    OnItemClickListener listener;
    ArrayList<DataShop> dataShops;
    Context context;
    int count = 1;

    public ShopAdapter(ArrayList<DataShop> dataShops,
                       Context context,
                       OnItemClickListener listener) {
       this.dataShops = dataShops;
        this.context = context;
        this.listener= listener;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from( parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row,parent, false);
        return new Viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull  Viewholder holder,int position) {
        final DataShop dataShop_position = dataShops.get(position);
        String name = dataShops.get(position).getTen();
        Integer image = dataShops.get(position).getHinhanh();
        Integer price =dataShops.get(position).getGia();
//        Integer amount=dataShops.get(position).getSoluong();

        holder.Name.setText(name);
//        holder.amount.setText(amount);
        holder.Price.setText("$"+price+"US");
        holder.Image.setImageResource(image);
        holder.Image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listener.onItemClick(dataShop_position);
            }
        });
    }



    @Override
    public int getItemCount() {
        return dataShops.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Name;
        ImageView Image;
        TextView Price;
        Button increment,decrement;
        TextView amount;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            Name=(TextView) itemView.findViewById(R.id.name);
            Image=(ImageView) itemView.findViewById(R.id.hinh);
            Price=(TextView ) itemView.findViewById(R.id.price);
            increment=(Button) itemView.findViewById(R.id.tanglen);
            decrement=(Button) itemView.findViewById(R.id.giamxuong);
            amount=(TextView) itemView.findViewById(R.id.soluong);
        }
        @Override
        public void onClick(View view) {

        }
    }
}

