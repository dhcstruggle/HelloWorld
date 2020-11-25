package helloworld.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.helloworld.R;

public class AFragment extends Fragment {
    private TextView mTvTitle;
    private Button mBtnChange,getmBtnReset,getmBtnMsg;
    private BFragment bFragment;
    private IOMessageClick listener;

    public interface IOMessageClick{
        void onClick(String str);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //getactivity 可能为null的情况
//        mActivity = (Activity) context;
        try {
            listener = (IOMessageClick) context;
        }catch (ClassCastException e){
            throw new ClassCastException(("Activity 必须实现 IOMessageClick"));
        }
    }

    public static AFragment newInstance(String str){
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mTvTitle = view.findViewById(R.id.tv_title);
        if (getArguments() != null) {
            mTvTitle.setText(getArguments().getString("title"));
        }

        mBtnChange = view.findViewById(R.id.btn_change);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment bFragment = getFragmentManager().findFragmentByTag("B");
                Fragment aFragment = getFragmentManager().findFragmentByTag("A");

                if (bFragment == null)
                {
                    bFragment = new BFragment();
                }

                if (aFragment != null) {
                    getFragmentManager().beginTransaction().hide(aFragment).add(R.id.fl_container, bFragment, "B").addToBackStack(null).commitAllowingStateLoss();
                }
                else{
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });

        getmBtnReset = view.findViewById(R.id.btn_reset);
        getmBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvTitle.setText("我是新文字");
            }
        });

        getmBtnMsg = view.findViewById(R.id.btn_msg);
        getmBtnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ((ContainerActivity)getActivity()).setData("AFragment data");
                listener.onClick("Afragmenet to Activity");
            }
        });
    }



    @Override
    public void onDetach() {
        super.onDetach();
        //取消异步
    }
}
