/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.com.pcschool.dd2018011701.data;

import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class StudentScoreDAO implements StudentDAO{
    public ArrayList<Student> myList;
    public StudentScoreDAO()
    {
        myList = new ArrayList<>();
    }
    public boolean add(Student s)
    {
        myList.add(s);
        return true;
    }
    public ArrayList<Student> getList()
    {
        return myList;
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
                return true;
            }
        }
        return false;
    }
    
}
