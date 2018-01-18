package tw.com.pcschool.dd2018011701;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import tw.com.pcschool.dd2018011701.data.Student;

public class DetailActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    Student s;
    int id;
    boolean fastBack = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        id = getIntent().getIntExtra("ID", 0);
    }

    @Override
    protected void onResume() {
        super.onResume();

//        if (fastBack)         假如要再回上一頁要這樣做
//        {
//            finish();
//        }
        s = MainActivity.dao.getStudent(id);        //要放在Resume,不然會用舊的s的資料
        tv1.setText("ID:" + String.valueOf(s.id));
        tv2.setText(s.name);
        tv3.setText(String.valueOf(s.score));
    }

    public void clickBack(View v)
    {
        finish();
    }
    public void clickDelete(View v)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(DetailActivity.this);
        dialog.setTitle("刪除確認");
        dialog.setMessage("確認刪除本筆資料?");
        dialog.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.dao.delete(id);
                finish();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }
    public void clickEdit(View v)
    {
        Intent it = new Intent(DetailActivity.this, EditActivity.class);
        it.putExtra("ID", id);
        fastBack = true;
        startActivity(it);
    }
}
