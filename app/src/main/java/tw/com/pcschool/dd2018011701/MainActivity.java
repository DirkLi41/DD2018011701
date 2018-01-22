package tw.com.pcschool.dd2018011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import tw.com.pcschool.dd2018011701.data.DBType;
import tw.com.pcschool.dd2018011701.data.Student;
import tw.com.pcschool.dd2018011701.data.StudentDAO;
import tw.com.pcschool.dd2018011701.data.StudentDAOFactory;
import tw.com.pcschool.dd2018011701.data.StudentFileDAO;
import tw.com.pcschool.dd2018011701.data.StudentScoreDAO;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> studentName;
    ArrayAdapter<String> adapter;
    public static StudentDAO dao;
    DBType dbtype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        dao = new StudentFileDAO(this);
        dbtype = DBType.DB;
        dao = StudentDAOFactory.getDAOInstance(this, dbtype);
    }

    @Override
    protected void onResume() {
        super.onResume();

        lv = (ListView) findViewById(R.id.listView);
        studentName = new ArrayList<>();
        for(Student s:dao.getList())
        {
            studentName.add(s.name);
        }
        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                studentName);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("ID", dao.getList().get(position).id);
                startActivity(it);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add)
        {
            Intent it = new Intent(MainActivity.this, AddActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
}
