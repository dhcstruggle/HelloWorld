package helloworld.fragment;

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

public class BFragment extends Fragment {
    private TextView mTvTitle;
    private Button mBtnChanegA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mTvTitle = view.findViewById(R.id.tv_title);
        mBtnChanegA = view.findViewById(R.id.btn_change);
        mBtnChanegA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment Bfragment = getFragmentManager().findFragmentByTag("B");
                Fragment Afragment = getFragmentManager().findFragmentByTag("A");
                if (Afragment == null) {
                    Afragment = AFragment.newInstance("我是参数");
                }
                if (Bfragment != null) {
                    getFragmentManager().beginTransaction().hide(Bfragment).show(Afragment).commitAllowingStateLoss();
                }
                else{
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, Bfragment).commitAllowingStateLoss();
                }

            }
        });
    }


}
