package helloworld.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.helloworld.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRvGrid = findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this, 4));
        //添加分隔线
        mRvGrid.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        //添加分隔线
        mRvGrid.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRvGrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void Onclick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "click" + pos, Toast.LENGTH_SHORT).show();
            }
        }, new GridAdapter.OnItemLongClickListener() {
            @Override
            public void OnLongclick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "Longclick" + pos, Toast.LENGTH_SHORT).show();
            }
        }));

    }
}