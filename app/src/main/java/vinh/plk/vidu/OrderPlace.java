package vinh.plk.vidu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import vinh.plk.vidu.data.ListProductDataShop;
import vinh.plk.vidu.fragment.HomeFagment;
import vinh.plk.vidu.recycleview.DataShop;

public class OrderPlace extends AppCompatActivity {
    TextView mDonhang;
    int randomNuber;
    Button backHome;
    ArrayList<DataShop> dataShopingCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_place);
        mDonhang = (TextView) findViewById(R.id.number_orderplace);
        backHome = (Button) findViewById(R.id.back_home) ;
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main1Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                ListProductDataShop.getInstance().cleardataCart();
            }
        });
        random();
    }


    public void random() {
        int randomNumber;
        Random r = new Random();
        randomNumber = r.nextInt();
        if (randomNumber < 0) {
            mDonhang.setText(String.valueOf("#" + randomNumber *-1));
        }
    }
}

