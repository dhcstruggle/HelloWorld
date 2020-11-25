package helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

import helloworld.util.ToastUtil;
import helloworld.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        mBtnCustomDialog = findViewById(R.id.btn_custom_dialog);
        mBtnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMsg("确认删除此项？").setCancel("取消",
                new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dg) {
                        ToastUtil.showMsg(CustomDialogActivity.this,"Cancel");
                    }
                }).setOk("确认", new CustomDialog.IOnOKListener() {
                    @Override
                    public void onOK(CustomDialog dg) {
                        ToastUtil.showMsg(CustomDialogActivity.this, "OK");
                    }
                }).setCancelable(false);

                customDialog.show();
            }
        });
    }
}