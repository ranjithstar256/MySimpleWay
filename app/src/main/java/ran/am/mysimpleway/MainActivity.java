package ran.am.mysimpleway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import ran.am.mysimpleway.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding amb;
    ArrayList itemsList;
    RecyclerviewItemAdapter recyclerviewItemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amb = DataBindingUtil.setContentView(this, R.layout.activity_main);

        itemsList=new ArrayList();
        prepareItems();
        amb.rv.setLayoutManager(new LinearLayoutManager(this));

        recyclerviewItemAdapter = new RecyclerviewItemAdapter(itemsList);
        amb.rv.setHasFixedSize(true);
        amb.rv.setItemAnimator(new DefaultItemAnimator());
        amb.rv.setAdapter(recyclerviewItemAdapter);

    }
    private void prepareItems(){
        for(int i = 0; i < 500; i++) {
            Items items = new Items("Item"+i,20+i);
            itemsList.add(items);
        }
    }
}