package tw.com.pcschool.dd2018011701;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import tw.com.pcschool.dd2018011701.data.Student;

public class AddActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
    public void clickAdd(View v)
    {
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        int id = Integer.valueOf(et1.getText().toString());
        String name = et2.getText().toString();
        int score = Integer.valueOf(et3.getText().toString());
        MainActivity.dao.add(new Student(id, name, score));
        finish();
    }

}
