import java.sql.*;

public class main {
    public static void main(String[] args){
        //声明资源对象
        Connection conn = null;
        Statement stmt = null;
        String sql = "CREATE TABLE t_student(`id` BIGINT PRIMARY KEY AUTO_INCREMENT,`name` VARCHAR(20), `age` INT)";
        String insert = "INSERT INTO t_student(name, age) VALUES ('乔峰',33)";
        String update = "UPDATE t_student SET name='阿朱' ,age=35 WHERE id = 8";
        String select = "SELECT COUNT(id)  FROM t_student ";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testDB","root","");
            stmt = conn.createStatement();
            //增加
//            int rows = stmt.executeUpdate(sql);
//            System.out.println(rows);

            //
//            int row1 = stmt.executeUpdate(update);


            ResultSet  re = stmt.executeQuery(select);
            if (re.next()) {
                long totalCount  = re.getLong(1);
                System.out.println("x==="+totalCount);
            }


            //修改 34

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
