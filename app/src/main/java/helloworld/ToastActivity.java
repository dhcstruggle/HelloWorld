package helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.helloworld.R;

import helloworld.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private Button mBtnToast1,mBtnToast2,mBtnToast3,mBtnToast4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        mBtnToast1 = findViewById(R.id.btn_toast_1);
        mBtnToast2 = findViewById(R.id.btn_toast_2);
        mBtnToast3 = findViewById(R.id.btn_toast_3);
        mBtnToast4 = findViewById(R.id.btn_toast_4);
        OnClick onclick = new OnClick();
        mBtnToast1.setOnClickListener(onclick);
        mBtnToast2.setOnClickListener(onclick);
        mBtnToast3.setOnClickListener(onclick);
        mBtnToast4.setOnClickListener(onclick);
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_toast_1:
                    //Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_LONG).show();
                    ToastUtil.showMsg(getApplicationContext(), "包装过的Toast");
                    break;
                case R.id.btn_toast_2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(), "居中显示", Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER, 0,0);
                    toastCenter.show();
                    break;
                case R.id.btn_toast_3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater inflater=LayoutInflater.from(ToastActivity.this);
                    View vieww = inflater.inflate(R.layout.layout_linear_item, null);

                    toastCustom.setView(vieww);
                    toastCustom.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtil.showMsg(getApplicationContext(), "包装过的Toast1");
                    break;
                default:
                    break;
            }

        }
    }
}