package vinh.plk.vidu.recycleview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import vinh.plk.vidu.Main1Activity;
import vinh.plk.vidu.R;
import vinh.plk.vidu.data.ListProductDataShop;

public class ShopAcitivity extends AppCompatActivity {
    TextView name;
    TextView price;
    ImageView image;
    Button addShop;
    Button increment,decrement;
    TextView amount;
    Button back;
    int count =1 ;
    ArrayList<DataShop> dataShops;
    Context context;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_fruit);
        back = (Button)findViewById(R.id.back);
        name = (TextView) findViewById(R.id.melon);
        price= (TextView) findViewById(R.id.shop_fruit_us);
        image= (ImageView) findViewById(R.id.oi);
        addShop=(Button) findViewById(R.id.add_shop);
        increment=(Button) findViewById(R.id.tanglen);
        decrement=(Button) findViewById(R.id.giamxuong);
        amount=(TextView) findViewById(R.id.soluong);
        onClickButton();




        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int priceFruit= getIntent().getExtras().getInt("Gia") ;
                count++;;
                amount.setText(count+"kg");
                int priceSum = priceFruit * count;
                String setnewPrice = String.valueOf(priceSum);
                price.setText(setnewPrice);
                price.setText("$"+ setnewPrice + "US");

            }
        });
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int priceFruit = getIntent().getExtras().getInt("Gia");
                if (count<=1) ;
                else
                    count--;
                amount.setText( count+"kg");
                int priceSum = priceFruit * count;
                String setnewPrice = String.valueOf(priceSum);
                price.setText(setnewPrice);
                price.setText("$"+ setnewPrice + "US");

            }
        });


        image.setImageResource(getIntent().getIntExtra("Hinhanh",0));
        name.setText(getIntent().getExtras().getString("Ten"));
        price.setText(getIntent().getExtras().getInt("Gia",1)+" US");
        amount.setText(getIntent().getExtras().getInt("soluong",1)+"kg");

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    void onClickButton(){

        addShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataShop item = new DataShop(getIntent().getIntExtra("Hinhanh", 0),
                        getIntent().getExtras().getString("Ten"),
                        getIntent().getExtras().getInt("Gia"),
                        count);
//              listProductDataShop.setDataShopingCart(item);
                ListProductDataShop.getInstance().setName(getIntent().getExtras().getString("Ten"));
                ListProductDataShop.getInstance().setDataShopingCart(item);
                Toast.makeText(ShopAcitivity.this, getIntent().getExtras().getString("Ten"), Toast.LENGTH_SHORT).show();
             finish();
            }
        });

         Intent intent = new Intent(this, Main1Activity.class);
         back.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View view) {
                 String message = back.getText().toString();

                 intent.putExtra("EXTRA_MESSAGE", message);
                 startActivity(intent);
             }

         });
    }
}

