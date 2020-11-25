package helloworld;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = LogActivity.class.getName();
    String cmds = "";
    StringBuilder Sb = new StringBuilder("this is log");
    private BufferedReader mReader = null;
    private Process exec;
    private int mPId;
    private String mStrPID;
    private boolean mRunning = true;
    TextView etlog;
    Button btnStop, btnSave, btnClear;
    RandomAccessFile randomFile = null;
    private final String mLogDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        setTitle("日志查看");


        etlog = findViewById(R.id.et_logs);
        etlog.setMovementMethod(ScrollingMovementMethod.getInstance());
        btnStop = findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(this);
        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
        btnClear = findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(this);
        mPId = android.os.Process.myPid();
        mStrPID = String.valueOf(mPId);
        cmds = "logcat  *:e *:d | grep \"(" + mStrPID + ")\"";
        ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            exec = Runtime.getRuntime().exec(cmds);
            mReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String line = "";
                    try {
                        while (mRunning && (line = mReader.readLine()) != null) {
                            Sb.append(line);
                            if (!mRunning) {
                                break;
                            }

                            if (line.length() == 0) {
                                continue;
                            }
                            final Message msg = Message.obtain();
                            msg.what = 2;
                            msg.obj = line + "\n";
                            mhandler.sendMessage(msg);
                            //Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        Log.e(TAG, e.toString());
                    } finally {
                        Log.e(TAG, "finally");
                        Log.e(TAG, "" + mRunning);
                        if (line == null) {
                            Log.e(TAG, "line is null");
                        }
                        if (exec != null) {
                            exec.destroy();
                        }
                        if (mReader != null) {
                            try {
                                mReader.close();
                                mReader = null;
                            } catch (IOException e) {
                            }
                        }
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //startShowLog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRunning = false;
        if (exec != null) {
            exec.destroy();
        }
        if (mReader != null) {
            try {
                mReader.close();
                mReader = null;
            } catch (IOException e) {
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_stop:
                mRunning = false;
                break;
            case R.id.btn_save:
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-ddHHmmss", Locale.CHINA);
                String date = format1.format(new Date(System.currentTimeMillis()));
                try {
                    String path = mLogDir + "/" + date + ".log";
                    randomFile = new RandomAccessFile(path, "rw");
                    randomFile.write(etlog.getText().toString().getBytes());
                    Toast.makeText(LogActivity.this, "日志保存成功,path=" + path, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    //LogUtil.d(e.toString());
                }
                break;
            case R.id.btn_clear:
                etlog.setText("");
                break;
        }
    }


    @SuppressLint("HandlerLeak")
    Handler mhandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    break;
                case 2:
                    //显示日志
                    etlog.append(msg.obj.toString());

                    //滚动到最后一行
                    int offset = etlog.getLayout().getLineTop(etlog.getLineCount()) - etlog.getHeight();
                    if (offset > 0){
                        etlog.scrollTo(0,offset);
                    }else{
                        etlog.scrollTo(0,0);
                    }
                    break;
            }
        }
    };
}