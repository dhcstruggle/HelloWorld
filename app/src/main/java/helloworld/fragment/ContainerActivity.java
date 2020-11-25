package helloworld.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.helloworld.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOMessageClick{

    private AFragment aFragment;
    private TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        aFragment = AFragment.newInstance("我是参数");

        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "A").commitAllowingStateLoss();
        //getFragmentManager().beginTransaction().add(R.id.fl_container, aFragment).commitAllowingStateLoss();

        mTvTitle = findViewById(R.id.tv_title);

    }

    public void setData(String text){
        mTvTitle.setText(text);
    }

    @Override
    public void onClick(String str) {
        mTvTitle.setText(str);
    }
}