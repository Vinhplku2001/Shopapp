package vinh.plk.vidu.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vinh.plk.vidu.R;

public class ListActivityDuct extends AppCompatActivity {
    TextView Name;
    TextView Price;
    ImageView Image;
    Button    back;


    private RecyclerView popularRecyclerView, bestSellerRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bestSellerRecyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
        popularRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        popularRecyclerView();
        bestSellerRecyclerView();

    }

    private void bestSellerRecyclerView() {
//        bestSellerRecyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
//        bestSellerRecyclerView.setLayoutManager(mLayoutManager);
//        ArrayList<DataShop> arrayList2 = new ArrayList<>();
//        arrayList2.add(new DataShop(R.drawable.ggrapes, "Green Grapes ", "$988 US"));
//        arrayList2.add(new DataShop(R.drawable.grapes, "Grapes", "$988 US"));
//        arrayList2.add(new DataShop(R.drawable.melon, "Melon","$988 US"));
//        arrayList2.add(new DataShop(R.drawable.mango,"Mango","$988 Us"));
//        ShopAdapter shopAdapter2 = new ShopAdapter(arrayList2,getApplication());
//        bestSellerRecyclerView.setAdapter(shopAdapter2);

    }

    private void popularRecyclerView() {
//        popularRecyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        popularRecyclerView.setLayoutManager(linearLayoutManager);
//
//        ArrayList<DataShop> arrayList = new ArrayList<>();
//        arrayList.add(new DataShop(R.drawable.pineapple, "Pineapple", "$955 US"));
//        arrayList.add(new DataShop(R.drawable.banana, "Bannana", "$955 US"));
//        ShopAdapter shopAdapter = new ShopAdapter(arrayList,getApplicationContext());
//        popularRecyclerView.setAdapter(shopAdapter);

    }

}