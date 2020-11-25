package helloworld.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.helloworld.R;

public class PuRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvPu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        mRvPu = findViewById(R.id.rv_pu);
        mRvPu.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvPu.setAdapter(new PuAdapter(PuRecyclerViewActivity.this, new PuAdapter.OnItemClickListener() {
            @Override
            public void Onclick(int pos) {
                Toast.makeText(PuRecyclerViewActivity.this, "click" + pos, Toast.LENGTH_SHORT).show();
            }
        }, new PuAdapter.OnItemLongClickListener() {
            @Override
            public void OnLongclick(int pos) {
                Toast.makeText(PuRecyclerViewActivity.this, "Longclick" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}