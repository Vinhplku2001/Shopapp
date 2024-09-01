//package vinh.plk.vidu.api;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import java.util.List;
//
//import model.Bank;
//import model.User;
//import retrofit2.Call;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.http.GET;
//import retrofit2.http.Query;
//
//public interface ServiceBank {
//    Gson gson = new GsonBuilder()
//            .setDateFormat("yyyy-MM-dd HH:mm:ss")
//            .create();
//    ServiceBank servicebank =  new Retrofit.Builder()
//            .baseUrl("https://api.vietqr.io/")
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//            .create(ServiceBank.class);
//
//
//    @GET("v2/banks/")
//    Call<List<User>> getListBank(@Query("short_name") String short_name,
//                                 @Query("name")String name);
//}
