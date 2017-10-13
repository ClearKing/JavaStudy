import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {
    @Override
    public void save(Student stu) {

    }

    @Override
    public void update(Long id, Student newStu) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Student get(Long id) {
        //1.加载注册驱动
        //2.获取连接对象
        //3.创建语句对象
        //4.执行sql
        //5.
        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;

        try {
            String sql = "SELECT * FROM t_student WHERE id = " + id;
            Class.forName("com.mysql.jdbc.Driver");
            //jdbc:mysql://localhost/testDB
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testDB","root","");
            stmt = conn.createStatement();
            res = stmt.executeQuery(sql);
            if (res.next()){ //说明有一个对象
                Student stu = new Student();
                stu.setId(res.getLong("id"));
                stu.setName(res.getString("name"));
                stu.setAge(res.getInt("age"));
                return stu;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (res != null) {
                    res.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    if (stmt != null){
                        stmt.close();
                    }
                }  catch (Exception e) {
                    e.printStackTrace();
                }finally {
                   try {
                       if (conn != null){
                           conn.close();
                       }
                   }catch (Exception e){
                       e.printStackTrace();
                   }
                }
            }
        }

        return null;
    }

    @Override
    public List<Student> list() {
        List<Student> list = new ArrayList<>();
        return null;
    }
}
