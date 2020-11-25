package helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloworld.R;
import helloworld.util.ToastUtil;

public class SharedPreferencesActivity extends AppCompatActivity {

    private Button mBtnSave,mBtnShow;
    private EditText mEtName;
    private TextView mTvContant;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mEtName = findViewById(R.id.et_name);
        mTvContant = findViewById(R.id.tv_ct);

        mSharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putString("name", mEtName.getText().toString());
                mEditor.apply();
                ToastUtil.showMsg(SharedPreferencesActivity.this, "保存成功");
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showMsg(SharedPreferencesActivity.this, "显示");
                mTvContant.setText(mSharedPreferences.getString("name",""));
            }
        });



    }
}