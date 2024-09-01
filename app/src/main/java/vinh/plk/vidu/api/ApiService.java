package vinh.plk.vidu.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import model.Currency;
import model.NameBank;
import model.User;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiService {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        ApiService apiService = new Retrofit.Builder()
                .baseUrl("https://api.vietqr.io/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ApiService.class);

        @GET("v2/banks/")
        Call<User> getListUser();
}
