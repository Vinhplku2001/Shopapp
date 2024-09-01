package vinh.plk.vidu.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import model.Bank;
import model.User;
import vinh.plk.vidu.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private  List<Bank> mListUser;
            Context mcontext;

    public UserAdapter(List<Bank> mListUser,Context mcontext) {
        this.mListUser = mListUser;
        this.mcontext  = mcontext;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bank,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Bank user = mListUser.get(position);
        if ( user == null){
            return;
        }
        holder.tvShortName.setText(user.getShort_name());
        holder.tvName.setText(user.getName());
        Glide.with(this.mcontext).load(user.getLogo()).into(holder.imageBank);

    }

    @Override
    public int getItemCount() {
        if (mListUser != null){
return  mListUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvShortName, tvName;
        private ImageView imageBank;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvShortName = itemView.findViewById(R.id.tv_short_name);
            tvName= itemView.findViewById(R.id.tv_name);
            imageBank = itemView.findViewById(R.id.image_bank);
        }
    }
}
