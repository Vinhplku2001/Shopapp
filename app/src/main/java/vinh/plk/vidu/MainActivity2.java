package vinh.plk.vidu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.Bank;
import model.NameBank;
import model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vinh.plk.vidu.api.ApiService;
import vinh.plk.vidu.recycleview.UserAdapter;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView rcvUser;
    private List<Bank> mListUser;
    private UserAdapter userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycele_api);
        rcvUser = findViewById(R.id.recycler_user);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this ,DividerItemDecoration.VERTICAL);
        rcvUser.addItemDecoration(itemDecoration);

        mListUser = new ArrayList<>();
//        mListUser.add(new User(1,"dd"));
//        UserAdapter userAdapter =  new UserAdapter(mListUser);
//        Toast.makeText(MainActivity2.this, "CAll Api Sucess " +  mListUser.size(), Toast.LENGTH_LONG).show();
//        rcvUser.setAdapter(userAdapter);
//        userAdapter = new UserAdapter(mListUser);
//
//        rcvUser.setAdapter(userAdapter);

        callApiService();

    }
    private void callApiService(){
        ApiService.apiService.getListUser().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
//                Toast.makeText(MainActivity2.this, "CAll Api Sucess " +  mListUser.size(), Toast.LENGTH_LONG).show();
                mListUser  = response.body().getData();
                UserAdapter userAdapter =  new UserAdapter(mListUser,peekAvailableContext());
                Toast.makeText(MainActivity2.this, "CAll Api Sucess " +  mListUser.size(), Toast.LENGTH_LONG).show();
                rcvUser.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity2.this,"CAll Api ERROR",Toast.LENGTH_LONG).show();
            }
        });
//        ApiService.apiService.getListUser().enqueue(new Callback<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                mListUser = response.body();
//                UserAdapter userAdapter =  new UserAdapter(mListUser);
//                Toast.makeText(MainActivity2.this, "CAll Api Sucess " +  mListUser.size(), Toast.LENGTH_LONG).show();
//                rcvUser.setAdapter(userAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//                Toast.makeText(MainActivity2.this,"CAll Api ERROR",Toast.LENGTH_LONG).show();
//            }
//        });
    }
}


