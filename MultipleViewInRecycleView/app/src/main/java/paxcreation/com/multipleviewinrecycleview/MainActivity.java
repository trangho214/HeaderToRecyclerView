package paxcreation.com.multipleviewinrecycleview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getHeader(), getListItems());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    public  Header getHeader()
    {
        Header header = new Header();
        header.setHeader("I'm header");
        return header;
    }

    public  List<ListItem> getListItems()
    {
        List<ListItem> listItems = new ArrayList<ListItem>();
        for (int i = 0; i<10; i++) {
            ListItem item = new ListItem();
            item.setName("image" + i);
            if (i % 2 == 0)
                item.setId(R.drawable.sweetlife);
            else
                item.setId(R.drawable.young);
            listItems.add(item);
        }
        return listItems;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
