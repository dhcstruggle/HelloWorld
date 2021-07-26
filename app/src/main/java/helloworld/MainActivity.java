package helloworld;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.helloworld.R;

import helloworld.bankservicedemo.BankServiceActivity;
import helloworld.broadcast.BroadActivity;
import helloworld.datastorage.DataStorageActivity;
import helloworld.fragment.ContainerActivity;
import helloworld.gridview.GridViewActivity;
import helloworld.jump.AActivity;
import helloworld.layout.LayoutActivity;
import helloworld.listview.ListViewActivity;
import helloworld.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioBtn;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecyclerView;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;
    private Button mBtnCusDialog;
    private Button mBtnPopWindow;
    private Button mBtnLifeCycle;
    private Button mBtnJump;
    private Button mBtnFragment;
    private Button mBtnEvent;
    private Button mBtnHandler;
    private Button mBtnData;
    private Button mBtnBroad;
    private Button mBtnMyTest;
    private Button mBtnService;
    private Button mBtnBankService;
    private Button mBtnLog;
    private Button mBtnLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        mBtnEditText = findViewById(R.id.btn_edittext);
        mBtnRadioBtn = findViewById(R.id.btn_radiobtn);
        mBtnCheckBox = findViewById(R.id.btn_checkbox);
        mBtnImageView = findViewById(R.id.btn_imageview);
        mBtnListView = findViewById(R.id.btn_listview);
        mBtnGridView = findViewById(R.id.btn_gridview);
        mBtnRecyclerView = findViewById(R.id.btn_recyclerview);
        mBtnWebView = findViewById(R.id.btn_webview);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnProgress= findViewById(R.id.btn_progress);
        mBtnCusDialog = findViewById(R.id.btn_cus_dialog);
        mBtnPopWindow = findViewById(R.id.btn_popup_window);
        mBtnLifeCycle = findViewById(R.id.btn_life_cycle);
        mBtnJump = findViewById(R.id.btn_junp);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnHandler  = findViewById(R.id.btn_handler);
        mBtnData  = findViewById(R.id.btn_data);
        mBtnBroad  = findViewById(R.id.btn_broad);
        mBtnMyTest = findViewById(R.id.btn_mytest);
        mBtnService = findViewById(R.id.btn_service);
        mBtnBankService = findViewById(R.id.btn_bank_service);
        mBtnLog = findViewById(R.id.btn_log);
        mBtnLayout = findViewById(R.id.btn_layout);
        setListeners();

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    private void setListeners(){
        mBtnTextView.setOnClickListener(this);
        mBtnButton.setOnClickListener(this);
        mBtnEditText.setOnClickListener(this);
        mBtnRadioBtn.setOnClickListener(this);
        mBtnCheckBox.setOnClickListener(this);
        mBtnImageView.setOnClickListener(this);
        mBtnListView.setOnClickListener(this);
        mBtnGridView.setOnClickListener(this);
        mBtnRecyclerView.setOnClickListener(this);
        mBtnWebView.setOnClickListener(this);
        mBtnToast.setOnClickListener(this);
        mBtnDialog.setOnClickListener(this);
        mBtnProgress.setOnClickListener(this);
        mBtnCusDialog.setOnClickListener(this);
        mBtnPopWindow.setOnClickListener(this);
        mBtnLifeCycle.setOnClickListener(this);
        mBtnJump.setOnClickListener(this);
        mBtnFragment.setOnClickListener(this);
        mBtnEvent.setOnClickListener(this);
        mBtnHandler.setOnClickListener(this);
        mBtnData.setOnClickListener(this);
        mBtnBroad.setOnClickListener(this);
        mBtnMyTest.setOnClickListener(this);
        mBtnService.setOnClickListener(this);
        mBtnBankService.setOnClickListener(this);
        mBtnLog.setOnClickListener(this);
        mBtnLayout.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent;
        Class<?> cls;
        switch (v.getId()){
            case R.id.btn_layout:
                cls = LayoutActivity.class;
                break;
            case R.id.btn_log:
                cls = LogActivity.class;
                break;
            case R.id.btn_bank_service:
                cls = BankServiceActivity.class;
                break;
            case R.id.btn_broad:
                cls = BroadActivity.class;
                break;
            case R.id.btn_mytest:
                cls = MyTestActivity.class;
                break;
            case R.id.btn_service:
                cls = ServiceActivity.class;
                break;
            case R.id.btn_data:
                cls = DataStorageActivity.class;
                break;
            case R.id.btn_handler:
                cls = HandlerActivity.class;
                break;
            case R.id.btn_textview:
                cls = TextViewActivity.class;
                break;
            case R.id.btn_edittext:
                cls = EditTextActivity.class;
                break;
            case R.id.btn_button:
                cls = ButtonActivity.class;
                break;
            case R.id.btn_radiobtn:
                cls = RadioBtnActivity.class;
                break;
            case R.id.btn_checkbox:
                cls = CheckBoxActivity.class;
                break;
            case R.id.btn_imageview:
                cls = ImageViewActivity.class;
                break;
            case R.id.btn_listview:
                cls = ListViewActivity.class;
                break;
            case R.id.btn_gridview:
                cls = GridViewActivity.class;
                break;
            case R.id.btn_recyclerview:
                cls = RecyclerViewActivity.class;
                break;
            case R.id.btn_webview:
                cls = WebViewActivity.class;
                break;
            case R.id.btn_toast:
                cls = ToastActivity.class;
                break;
            case R.id.btn_dialog:
                cls = DialogActivity.class;
                break;
            case R.id.btn_progress:
                cls = ProgressActivity.class;
                break;
            case R.id.btn_cus_dialog:
                cls = CustomDialogActivity.class;
                break;
            case R.id.btn_popup_window:
                cls = PopupWindowActivity.class;
                break;
            case R.id.btn_life_cycle:
                cls = LifeCycleActivity.class;
                break;
            case R.id.btn_junp:
                cls = AActivity.class;
                break;
            case R.id.btn_fragment:
                cls = ContainerActivity.class;
                break;
            case R.id.btn_event:
                cls = EventActivity.class;
                break;
            default:
                Toast.makeText(MainActivity.this, "No such Btn" + v.getId(), Toast.LENGTH_SHORT).show();
                return;
        }

        intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }


}