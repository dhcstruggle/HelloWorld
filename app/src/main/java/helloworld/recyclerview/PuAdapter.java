package helloworld.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;

public class PuAdapter extends RecyclerView.Adapter<PuAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mlistener;
    private OnItemLongClickListener mllistener;

    public PuAdapter(Context context, OnItemClickListener listener, OnItemLongClickListener llistener){
        this.mContext = context;
        this.mlistener = listener;
        this.mllistener = llistener;
    }
    @Override
    public PuAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_pu_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PuAdapter.LinearViewHolder holder, final int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistener.Onclick(position);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mllistener.OnLongclick(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;


        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }

    public interface OnItemClickListener{
        void Onclick(int pos);
    }

    public interface OnItemLongClickListener{
        void OnLongclick(int pos);
    }
}
