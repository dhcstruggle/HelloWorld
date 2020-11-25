package helloworld.bankservicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.helloworld.R;

public class BankServiceActivity extends AppCompatActivity {

    private static final String TAG = BankServiceActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_service);

        Intent intent = new Intent(this, BankService.class);




    }

    public void normalUserClick(View v){
        Intent intent = new Intent();
        intent.setClass(this, NormalUserActivity.class);
        startActivity(intent);

    }

    public void bankWorkerClick(View v){
        startActivity(new Intent(this, BankWorkerActivity.class));
    }

    public void bankBossClick(View v){
        startActivity(new Intent(this, BankBossActivity.class));
    }
}