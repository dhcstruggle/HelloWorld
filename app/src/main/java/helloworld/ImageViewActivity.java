package helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.helloworld.R;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView mIv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        mIv6 = findViewById(R.id.iv_6);
    }
}