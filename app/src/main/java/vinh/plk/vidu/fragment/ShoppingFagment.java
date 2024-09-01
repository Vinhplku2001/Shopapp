package vinh.plk.vidu.fragment;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


import vinh.plk.vidu.Delivery_address;
import vinh.plk.vidu.OrderPlace;
import vinh.plk.vidu.R;
import vinh.plk.vidu.data.ListProductDataShop;
import vinh.plk.vidu.recycleview.CartAdapter;

import vinh.plk.vidu.recycleview.DataShop;
import vinh.plk.vidu.recycleview.ShopAcitivity;

public class ShoppingFagment extends Fragment {
    Button delete;
    Button edit;
    TextView Name;
    TextView price;
    ImageView hinhanh;
    Button   search;
    Button   checkout;

    int count =0;
    private TextView total,priceNew;
    private RecyclerView rcvCart;
    private ArrayList<DataShop> dataShops;
    private CartAdapter cartAdapter;
    ArrayList <DataShop> dataShopingCart;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shoppingcart, container, false);
        search = view.findViewById(R.id.search_cart);
        total  = view.findViewById(R.id.total);
        priceNew =view.findViewById(R.id.price_new);
        checkout= view.findViewById(R.id.shop_fruit_checkout);
        delete = view.findViewById(R.id.delete_cart);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( dataShopingCart != null) {
                    Intent intent = new Intent(getContext(), Delivery_address.class);
                    startActivity(intent);
                }
                else {



                }
            }
        });
        if(dataShopingCart == null){
            dataShopingCart = new ArrayList<>();
        }
        rcvCart=  view.findViewById(R.id.cartrecycler);
        rcvCart();

        return view;

    }


    @Override
    public void onResume() {
        super.onResume();
        cartAdapter.updateAdapter(ListProductDataShop.getInstance().getDataShopingCart());
    }

    private void rcvCart() {
        rcvCart.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(),1);
        rcvCart.setLayoutManager(mLayoutManager);
//        ListProductDataShop.getInstance().setDataBestSellerShop();
        cartAdapter = new CartAdapter(ListProductDataShop.getInstance().getDataShopingCart(), getContext(), new CartAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int index) {
                Log.d("index: ", index+"");
                ListProductDataShop.getInstance().delete(index);
                cartAdapter.updateAdapter(ListProductDataShop.getInstance().getDataShopingCart());
                sumPrice();

            }
        });
        rcvCart.setAdapter(cartAdapter);
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("TAG", "onClick: dsd");
//            }
//        });

      sumPrice();
    }


    public void sumPrice(){
        Integer sum= 0;
        ArrayList<DataShop> list = ListProductDataShop.getInstance().getDataShopingCart();
        for(int i=0; i<list.size(); i++) {
            DataShop item = list.get(i);
            Integer a = item.getSoluong()*item.getGia();
            sum+=a;
        }
        priceNew.setText("$"+(sum)+"US");
    }


}





