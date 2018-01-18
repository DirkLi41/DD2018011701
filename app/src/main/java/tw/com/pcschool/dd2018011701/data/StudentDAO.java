package tw.com.pcschool.dd2018011701.data;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/18.
 */

public interface StudentDAO {
    public ArrayList<Student> getList();
    public boolean add(Student s);
    public Student getStudent(int id);
    public boolean update(Student s);
    public boolean delete(int id);

}
