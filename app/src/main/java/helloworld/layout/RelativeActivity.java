package helloworld.layout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class RelativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        setTitle("RelativeActivity");
    }
}