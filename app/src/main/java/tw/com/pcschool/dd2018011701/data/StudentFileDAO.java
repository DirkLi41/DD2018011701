package tw.com.pcschool.dd2018011701.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Student on 2018/1/18.
 */

public class StudentFileDAO implements StudentDAO{
    public ArrayList<Student> myList;
    Context context;
    public StudentFileDAO(Context context)
    {
        this.context = context;
        myList = new ArrayList<>();
    }

    public void save()
    {
        File f = new File(context.getFilesDir(), "myList.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(myList);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load()
    {
        File f = new File(context.getFilesDir(), "myList.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Gson gson = new Gson();
            myList = gson.fromJson(str, new TypeToken<ArrayList<Student>>(){}.getType());
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getList()
    {
        load();
        return myList;
    }

    public boolean add(Student s)
    {
        myList.add(s);
        save();
        return true;
    }

    public Student getStudent(int id)
    {
        load();
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
        load();
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
        load();
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
