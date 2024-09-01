package vinh.plk.vidu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vinh.plk.vidu.fragment.ShoppingFagment;
import vinh.plk.vidu.recycleview.ShopAcitivity;


public class Delivery_address extends AppCompatActivity {
    Button pinFill, credit;
    EditText name, phone, address;
    Button ctn, addCard, backOut;
    View viewGroup1, viewGroup2, view3;
    SharedPreferences sharedPreferences;
    String flag = "address";
    private static final String SHARE_PRES = " sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_address);
        view3 = findViewById(R.id.linear_delivery);
        addCard = (Button) findViewById(R.id.add_card);
        name = (EditText) findViewById(R.id.full_name);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.dress);
        pinFill = (Button) findViewById(R.id.pin_fill);
        credit = (Button) findViewById(R.id.credit_card);
        viewGroup1 = findViewById(R.id.linear_deli);
        viewGroup2 = findViewById(R.id.linear_2);
        ctn = findViewById(R.id.continue_del);
        backOut = findViewById(R.id.back_deli);

        pinFill.setBackground(getBaseContext().getDrawable(R.drawable.pin_fill_click));
        credit.setBackground(getBaseContext().getDrawable(R.drawable.credit_card_fill));
        viewGroup2.setVisibility(View.GONE);
        onClickButton();
        sharedPreferences = getSharedPreferences(SHARE_PRES, MODE_PRIVATE);
        if (sharedPreferences != null) {
            name.setText(sharedPreferences.getString("FullName", ""));
            phone.setText(sharedPreferences.getString("Phone", ""));
            address.setText(sharedPreferences.getString("Address", ""));
        }



    }


    void onClickButton() {

        Intent intent = new Intent(this,OrderPlace.class);
        ctn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences();
                if (flag == "address") {
                    credit.setBackground(getBaseContext().getDrawable(R.drawable.credit_card));
                    pinFill.setBackground(getBaseContext().getDrawable(R.drawable.pin_fill));
                    viewGroup1.setVisibility(View.GONE);
                    viewGroup2.setVisibility(view.VISIBLE);
                    credit.setBackground(getBaseContext().getDrawable(R.drawable.credit_card));
                    flag = "cart";
                }
                else if (flag == "cart") {
                    startActivity(intent);
                }
            }
        });

        pinFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (viewGroup1.getVisibility() == View.GONE) {
                    viewGroup1.setVisibility(View.VISIBLE);
                    viewGroup2.setVisibility(View.GONE);
                    ctn.setVisibility(View.VISIBLE);
                    flag = "address";
                    pinFill.setBackground(getBaseContext().getDrawable(R.drawable.pin_fill));

                    pinFill.setBackground(getBaseContext().getDrawable(R.drawable.pin_fill_click));
                    credit.setBackground(getBaseContext().getDrawable(R.drawable.credit_card_fill));
                }
            }
        });
        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewGroup2.getVisibility() == View.VISIBLE) ;
                {
                    credit.setBackground(getBaseContext().getDrawable(R.drawable.credit_card));
                    pinFill.setBackground(getBaseContext().getDrawable(R.drawable.pin_fill));
                    viewGroup1.setVisibility(View.GONE);
                    flag = "cart";
                    viewGroup2.setVisibility(view.VISIBLE);
                    credit.setBackground(getBaseContext().getDrawable(R.drawable.credit_card));
                }
            }
        });
        Intent intent2 = new Intent(this,MainActivity2.class);

        addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = addCard.getText().toString();

                intent2.putExtra("EXTRA_MESSAGE", message);
                startActivity(intent2);

            }
        });

    }

    protected void sharedPreferences() {

        String Name = name.getText().toString();
        String Phone = phone.getText().toString();
        String Address = address.getText().toString();

            if (ctn.isClickable()) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("FullName", Name);
                editor.putString("Phone", Phone);
                editor.putString("Address", Address);
                editor.commit();
            }

            }
        }






