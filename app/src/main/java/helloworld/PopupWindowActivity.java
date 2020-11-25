package helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.helloworld.R;

import helloworld.util.ToastUtil;

public class PopupWindowActivity extends AppCompatActivity {

    private Button mBtnPop;
    private PopupWindow mPopWin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        mBtnPop = findViewById(R.id.btn_pop);
        mBtnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = getLayoutInflater().inflate(R.layout.layout_pop, null);
                mPopWin = new PopupWindow(v, mBtnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);

                TextView tv = v.findViewById(R.id.tv_good);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ToastUtil.showMsg(PopupWindowActivity.this, "Good");
                        mPopWin.dismiss();
                    }
                });

                mPopWin.setOutsideTouchable(true);
                mPopWin.setFocusable(true);
                mPopWin.showAsDropDown(mBtnPop);
            }
        });
    }
}