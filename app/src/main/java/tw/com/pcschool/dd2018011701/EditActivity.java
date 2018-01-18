package tw.com.pcschool.dd2018011701;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import tw.com.pcschool.dd2018011701.data.Student;

public class EditActivity extends AppCompatActivity {

    TextView tv4;
    EditText et4, et5;
    int id;
    Student s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        tv4 = (TextView) findViewById(R.id.textView4);
        et4 = (EditText) findViewById(R.id.editText4);
        et5 = (EditText) findViewById(R.id.editText5);
        id = getIntent().getIntExtra("ID", 0);
        s = MainActivity.dao.getStudent(id);

        tv4.setText("ID:" + String.valueOf(s.id));
        et4.setText(s.name);
        et5.setText(String.valueOf(s.score));
    }
    public void clickCancel(View v)
    {
        finish();
    }
    public void clickUpdate(View v)
    {
//        s.name = et4.getText().toString();            自己想到沒有用DAO方法的方法
//        s.score = Integer.valueOf(et5.getText().toString());
        MainActivity.dao.update(new Student(id, et4.getText().toString(), Integer.valueOf(et5.getText().toString())));
        finish();
    }
}
