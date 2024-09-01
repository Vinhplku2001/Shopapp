package vinh.plk.vidu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vinh.plk.vidu.api.ServicePhoto;

public class ParserJsonRetrofit extends AppCompatActivity {
    private static final String PHOTO_URL= "https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parser_json_retrofit);
    }
    public void getJonData(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PHOTO_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicePhoto servicePhoto = retrofit.create(ServicePhoto.class);
        Call<List<Photo>> call = servicePhoto.getAllPhtos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                Toast.makeText(ParserJsonRetrofit.this, "CAll Api Sucess", Toast.LENGTH_LONG).show();
                getData(response.body());

            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Toast.makeText(ParserJsonRetrofit.this, "CAll Api ERROR", Toast.LENGTH_LONG).show();

            }
        });
    }
    private void getData(List<Photo> ls ){
        Log.i("//=====Size","=>"+ls.size());
        for (Photo p:ls){
            Log.i("//=====Photo","=>"+p.toString());}

    }
}