package helloworld.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld.R;

public class MyGridAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyGridAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyGridAdapter.ViewHolder holder = null;
        if (view == null){
            view = mLayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder = new MyGridAdapter.ViewHolder();
            holder.imageView = view.findViewById(R.id.iv);
            holder.tvTitle = view.findViewById(R.id.tv_title);
            holder.tvTime = view.findViewById(R.id.tv_time);
            holder.tvContent = view.findViewById(R.id.tv_content);
            view.setTag(holder);
        }else{
            holder = (MyGridAdapter.ViewHolder) view.getTag();
        }

        holder.tvTitle.setText("标题" + String.valueOf(i));
        holder.tvTime.setText("20200722" + String.valueOf(i));
        holder.tvContent.setText("这是内容" + String.valueOf(i));

        return view;
    }
}
