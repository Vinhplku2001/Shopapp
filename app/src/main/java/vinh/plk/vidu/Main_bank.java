//package vinh.plk.vidu;
//
//import android.os.Bundle;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import model.Bank;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import vinh.plk.vidu.api.ServiceBank;
//import vinh.plk.vidu.recycleview.BankAdapter;
//import vinh.plk.vidu.recycleview.UserAdapter;
//
//public class Main_bank extends AppCompatActivity {
//    private RecyclerView rcvBank;
//    private List<Bank> mListBank;
//    private BankAdapter bankAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.recycler_api_bank);
//        rcvBank = findViewById(R.id.recycler_bank);
//        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this);
//        rcvBank.setLayoutManager(linearLayoutManager);
//        DividerItemDecoration itemDecoration = new DividerItemDecoration(this , DividerItemDecoration.VERTICAL);
//        rcvBank.addItemDecoration(itemDecoration);
//         mListBank = new ArrayList<Bank>();
//        CallServiceBank();
//    }
//    private void CallServiceBank(){
//        ServiceBank.servicebank.getListBank("short_name","name").enqueue(new Callback<List<Bank>>() {
//            @Override
//            public void onResponse(Call<List<Bank>> call, Response<List<Bank>> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Bank>> call, Throwable t) {
//
//            }
//        });
//    }
//}