//package vinh.plk.vidu.recycleview;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//import model.Bank;
//import vinh.plk.vidu.R;
//
//public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder>{
//    private List<Bank> mListBank;
//
//    public BankAdapter(List<Bank> _mListBank) {
//        this.mListBank =_mListBank;
//    }
//
//    @NonNull
//    @Override
//    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bank,parent,false);
//        return new BankViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull BankViewHolder holder, int position) {
//        Bank bank = mListBank.get(position);
//        if(bank == null ){
//            return;
//        }
//        holder.tvShortName.setText(bank.getShort_name());
//        holder.tvName.setText(bank.getName());
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        if (mListBank != null){
//            return  mListBank.size();
//        }
//        return 0;
//    }

//    public class BankViewHolder extends RecyclerView.ViewHolder{
//        private TextView tvShortName, tvName;
//
//        public BankViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tvShortName = (itemView).findViewById(R.id.tv_short_name);
//            tvName      = (itemView).findViewById(R.id.tv_name);
//
//        }
//
//    }
//}
