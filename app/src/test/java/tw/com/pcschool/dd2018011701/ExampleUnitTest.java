package tw.com.pcschool.dd2018011701;

import org.junit.Test;

import tw.com.pcschool.dd2018011701.data.Student;
import tw.com.pcschool.dd2018011701.data.StudentScoreDAO;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
//    @Test
//    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//    }
//    @Test
//    public void test1() throws Exception
//    {
//        assertEquals(6, 3 + 3);
//    }
//    @Test
//    public void test2() throws Exception
//    {
//        Test1 t1 = new Test1();
//        assertEquals(5, t1.getAdd(3, 3));
//    }
    @Test
    public void test_add_data() throws Exception
    {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1, "Dirk", 100));
        dao.add(new Student(2, "Irving", 95));
        dao.add(new Student(3, "Rose", 90));
        assertEquals(3, dao.getList().size());
    }
    @Test
    public void test_add_data2() throws Exception
    {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1, "Dirk", 100));
        dao.add(new Student(2, "Irving", 95));
        dao.add(new Student(3, "Rose", 90));
        assertEquals(90, dao.getList().get(2).score);
    }
    @Test
    public void test_getStudent() throws Exception
    {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1, "Dirk", 100));
        dao.add(new Student(2, "Irving", 95));
        dao.add(new Student(3, "Rose", 90));
        assertEquals(95, dao.getStudent(2).score);
    }
    @Test
    public void test_getStudent2() throws Exception
    {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1, "Dirk", 100));
        dao.add(new Student(2, "Irving", 95));
        dao.add(new Student(3, "Rose", 90));
        assertEquals(null, dao.getStudent(4));
    }
    @Test
    public void test_update() throws Exception
    {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1, "Dirk", 100));
        dao.add(new Student(2, "Irving", 95));
        dao.add(new Student(3, "Rose", 90));
        dao.update(new Student(3, "Rose", 85));
        assertEquals(85, dao.getStudent(3).score);
    }
    @Test
    public void test_delete() throws Exception
    {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1, "Dirk", 100));
        dao.add(new Student(2, "Irving", 95));
        dao.add(new Student(3, "Rose", 90));
        dao.delete(3);
        assertEquals(2, dao.getList().size());
    }
    @Test
    public void test_delete2() throws Exception
    {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1, "Dirk", 100));
        dao.add(new Student(2, "Irving", 95));
        dao.add(new Student(3, "Rose", 90));
        dao.delete(3);
        assertEquals(2, dao.getList().get(1).id);
    }

}