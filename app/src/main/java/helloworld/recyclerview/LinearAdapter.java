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

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mlistener;
    private OnItemLongClickListener mllistener;

    public LinearAdapter(Context context, OnItemClickListener listener, OnItemLongClickListener llistener){
        this.mContext = context;
        this.mlistener = listener;
        this.mllistener = llistener;
    }
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent, false));
        }else{
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item2, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position % 2);
    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, final int position) {
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
