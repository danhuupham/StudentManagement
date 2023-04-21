import dan.models.Student;
import dan.dao.StudentDao;

public class Test {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        System.out.println(studentDao.get("STDNT23001"));
    }
}
