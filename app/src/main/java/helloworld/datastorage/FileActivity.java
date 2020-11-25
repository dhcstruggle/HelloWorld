package helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloworld.R;
import helloworld.util.ToastUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    private Button mBtnSave,mBtnShow;
    private EditText mEtName;
    private TextView mTvContant;

    private final String mFileName = "test.txt";
    private final String mexDirName = "/chaos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mEtName = findViewById(R.id.et_name);
        mTvContant = findViewById(R.id.tv_ct);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(mEtName.getText().toString());
                ToastUtil.showMsg(FileActivity.this, "保存成功");
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvContant.setText(read());
                ToastUtil.showMsg(FileActivity.this, "显示");
            }
        });
    }

    //存储数据
    private void save(String contant){
        FileOutputStream fileOutputStream = null;
        try {
            File dir = new File(Environment.getExternalStorageDirectory(), mexDirName);
            if (!dir.exists()){
                dir.mkdirs();
            }

            File file = new File(dir, mFileName);
            if (!file.exists()){
                file.createNewFile();
            }

            //外部存储
            fileOutputStream = new FileOutputStream(file);
            //内部存储
            //fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE);
            fileOutputStream.write(contant.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //读取数据
    private String read(){
        FileInputStream fileInputStream = null;
        try {
            //外部存储
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + mexDirName, mFileName);
            fileInputStream = new FileInputStream(file);

            //内部存储
//            fileInputStream = openFileInput(mFileName);
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while((len = fileInputStream.read(buff))> 0)
                sb.append(new String(buff, 0 ,len));

            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}