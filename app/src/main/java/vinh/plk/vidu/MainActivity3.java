package vinh.plk.vidu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import model.Currency;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vinh.plk.vidu.api.ApiService;
//
//public class MainActivity3 extends AppCompatActivity {
//    private TextView tvTerms, tvSource, tvUSDVND ;
//    private Button bntCallApi;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        tvTerms =(TextView) findViewById(R.id.tv_terms);
//        tvSource=(TextView) findViewById(R.id.source);
//        tvUSDVND=(TextView) findViewById(R.id.usdvnd);
//        bntCallApi=(Button) findViewById(R.id.btn_callApi);
////        tvSource.setText(1);
//        bntCallApi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                    clickCallApi();
//            }
//        });
//
//    }

//    private void clickCallApi() {
//        //http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
//        ApiService.apiService.convertUsdtoVnd().enqueue(new Callback<Currency>() {
//            @Override
//            public void onResponse(Call<Currency> call, Response<Currency> response) {
//                Toast.makeText(MainActivity3.this, "CAll Api Sucess", Toast.LENGTH_LONG).show();
//                Currency currency = response.body();
//
//
//                tvTerms.setText(currency.getLogin());
//                tvSource.setText(Integer.toString(currency.getId()));
//                tvUSDVND.setText(currency.getEventsUrl());
//
//            }
//
//            @Override
//            public void onFailure(Call<Currency> call, Throwable t) {
//                Toast.makeText(MainActivity3.this,"CAll Api ERROR",Toast.LENGTH_LONG).show();
//
//            }
//        });
//    }
//}