package vinh.plk.vidu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vinh.plk.vidu.R;
import vinh.plk.vidu.data.ListProductDataShop;
import vinh.plk.vidu.recycleview.DataShop;
import vinh.plk.vidu.recycleview.ShopAcitivity;
import vinh.plk.vidu.recycleview.ShopAdapter;


public class HomeFagment extends Fragment {
    TextView Name;
    TextView Price;
    ImageView Image;
    private  ArrayList<DataShop> dataShops;
    private ArrayList<DataShop> dataBestSeller;
    private ArrayList<DataShop> dataPopular;
    private RecyclerView popularRecyclerView, bestSellerRecyclerView;
    private ShopAdapter shopAdapter;
    private RecyclerView recyclerView2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        popularRecyclerView = view.findViewById(R.id.recycler_view);
        bestSellerRecyclerView = view.findViewById(R.id.recycler_view2);
        popularRecyclerView();
        bestSellerRecyclerView();
        return view;

    }

    private void bestSellerRecyclerView() {
        bestSellerRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        bestSellerRecyclerView.setLayoutManager(mLayoutManager);;
       ListProductDataShop.getInstance().setDataBestSellerShop();

        ShopAdapter shopAdapter = new ShopAdapter(ListProductDataShop.getInstance().getDataBestSeller(), getContext(), new ShopAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DataShop item) {
                Intent intent = new Intent(getContext(), ShopAcitivity.class);
                intent.putExtra("Hinhanh", item.getHinhanh());
                intent.putExtra("Ten", item.getTen());
                intent.putExtra("Gia", item.getGia());
                getContext().startActivity(intent);
            }
        });
        bestSellerRecyclerView.setAdapter(shopAdapter);
    }



    private void popularRecyclerView() {
        popularRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<DataShop> arrayList = new ArrayList<>();
        ListProductDataShop.getInstance().setDataPopularShop();
        ShopAdapter shopAdapter = new ShopAdapter(ListProductDataShop.getInstance().getDataPopularShop(), getContext(), new ShopAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(DataShop item) {
               Intent intent2= new Intent(getContext() ,ShopAcitivity.class);
               intent2.putExtra("Hinhanh",item.getHinhanh());
               intent2.putExtra("Ten",item.getTen());
               intent2.putExtra("Gia",item.getGia());
               getContext().startActivity(intent2);
           }
       });
        popularRecyclerView.setAdapter(shopAdapter);
   }
}



