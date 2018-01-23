package tw.com.pcschool.dd2018011701.data;

import android.content.Context;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import tw.com.pcschool.dd2018011701.MainActivity;

/**
 * Created by Student on 2018/1/18.
 */

public class StudentCloudDAO implements StudentDAO{
    public ArrayList<Student> myList;
    Context context;
    FirebaseDatabase database;
    DatabaseReference myRef;

    public StudentCloudDAO(final Context context)
    {
        this.context = context;

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("scores");
        if (myList == null)
        {
            myList = new ArrayList<>();
        }
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Gson gson = new Gson();
                myList = gson.fromJson(value, new TypeToken<ArrayList<Student>>(){}.getType());
                ((MainActivity) context).refreshData();
            }

            @Override
            public void onCancelled(DatabaseError error){
                // Failed to read value

            }
        });

    }

    public void save()
    {
        // Write a message to the database
        Gson gson = new Gson();
        String data = gson.toJson(myList);

        myRef.setValue(data);
    }

    public ArrayList<Student> getList()
    {
        return myList;
    }

    public boolean add(Student s)
    {
        if (myList == null)
        {
            myList = new ArrayList<>();
        }
        myList.add(s);
        save();
        return true;
    }

    public Student getStudent(int id)
    {
        for (Student s:myList)
        {
            if (s.id == id)
            {
                return s;
            }
        }
        return null;
    }

    public boolean update(Student s)
    {
        for (Student t:myList)
        {
            if (t.id == s.id) {
                t.name = s.name;
                t.score = s.score;
                save();
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id)
    {
        for (int i = 0; i < myList.size(); i++)
        {
            if (myList.get(i).id == id)
            {
                myList.remove(i);
                save();
                return true;
            }
        }
        return false;
    }

}
