package helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

import helloworld.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button mBtnDialog1,mBtnDialog2,mBtnDialog3,mBtnDialog4,mBtnDialog5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        mBtnDialog1 = findViewById(R.id.btn_dialog_1);
        mBtnDialog2 = findViewById(R.id.btn_dialog_2);
        mBtnDialog3 = findViewById(R.id.btn_dialog_3);
        mBtnDialog4 = findViewById(R.id.btn_dialog_4);
        mBtnDialog5 = findViewById(R.id.btn_dialog_5);
        Onclick onclick = new Onclick();
        mBtnDialog1.setOnClickListener(onclick);
        mBtnDialog2.setOnClickListener(onclick);
        mBtnDialog3.setOnClickListener(onclick);
        mBtnDialog4.setOnClickListener(onclick);
        mBtnDialog5.setOnClickListener(onclick);
    }

    class Onclick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_dialog_1:
                    final AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答").setMessage("How do you feel").setIcon(R.mipmap.ic_launcher)
                            .setPositiveButton("Good", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this, "You Good");
                        }
                    }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this, "see again");
                        }
                    }).setNegativeButton("Not Good", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this, "Bad");
                        }
                    }).show();

                    break;
                case R.id.btn_dialog_2:
                    final String[] array2=new String[]{"Boy","Girl"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("Choose Gent:").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this,array2[i]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog_3:
                    final String[] array3=new String[]{"Boy","Girl"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("Choose Gent:").setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogActivity.this,array3[i]);
                        }
                    }).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).show();
                    break;
                case R.id.btn_dialog_4:
                    final String[] array4=new String[]{"Singing","Dancing","Coding"};
                    boolean[] favb = new boolean[]{true,false,true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("Choose Fav:").setMultiChoiceItems(array4, favb, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            ToastUtil.showMsg(DialogActivity.this, array4[i] + ":" + b);
                        }
                    }).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).show();
                    break;
                case R.id.btn_dialog_5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View v = LayoutInflater.from(DialogActivity.this).inflate(R.layout.activity_edit_text, null);
                    Button btnlogin = v.findViewById(R.id.et_btn1);
                    btnlogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ToastUtil.showMsg(DialogActivity.this,"Login OK");

                        }
                    });
                    builder5.setTitle("Login").setView(v).show();
                    break;
                default:
                    break;

            }
        }
    }
}