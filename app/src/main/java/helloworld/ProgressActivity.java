package helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.helloworld.R;

import helloworld.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mPb1,mPb2,mPb3,mPb4;
    private Button mBtnaddP,mBtnPgDg1,mBtnPgDg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mPb1 = findViewById(R.id.pb1);
        mPb2 = findViewById(R.id.pb2);
        mPb3 = findViewById(R.id.pb3);
        mPb4 = findViewById(R.id.pb4);

        mBtnaddP = findViewById(R.id.btn_addp);
        mBtnaddP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.sendEmptyMessage(0);
            }
        });

        mBtnPgDg1 = findViewById(R.id.btn_pg_dialog1);
        mBtnPgDg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("Tip");
                progressDialog.setMessage("loading...");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        ToastUtil.showMsg(ProgressActivity.this, "Cancel");
                    }
                });

                progressDialog.show();
            }
        });

        mBtnPgDg2 = findViewById(R.id.btn_pg_dialog2);
        mBtnPgDg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog2 = new ProgressDialog(ProgressActivity.this);
                progressDialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog2.setTitle("Tip");
                progressDialog2.setMessage("loading...");
                progressDialog2.setCancelable(false);
                progressDialog2.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                progressDialog2.show();
            }
        });
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mPb3.getProgress() < 100){
                handler.postDelayed(runnable, 500);
            }else{
                ToastUtil.showMsg(ProgressActivity.this, "add OK");
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };


}