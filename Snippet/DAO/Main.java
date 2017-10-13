import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        IStudentDAO dao = new StudentDAOImpl();
        Student stu = dao.get(1L);
        System.out.println(stu);
    }

}
