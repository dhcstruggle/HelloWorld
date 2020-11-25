package helloworld.layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class LayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        setTitle("LayoutActivity");
    }

    public void LayoutClick(View v){
        Intent intent = null;
        Class<?> cls = null;
        switch (v.getId()){
            case R.id.btn_absolute:
                cls = AbsoluteActivity.class;
                break;
            case R.id.btn_frame:
                cls = FrameLayoutActivity.class;
                break;
            case R.id.btn_table:
                cls = TableLayoutActivity.class;
                break;
            case R.id.btn_linear:
                cls = LinearActivity.class;
                break;
            case R.id.btn_constrain:
                cls = ConstrainActivity.class;
                break;
            case R.id.btn_relative:
                cls = RelativeActivity.class;
                break;
            default:
                Toast.makeText(LayoutActivity.this, "No such Btn" + v.getId(), Toast.LENGTH_SHORT).show();
                return;
        }

        intent = new Intent(LayoutActivity.this, cls);
        startActivity(intent);
    }
}