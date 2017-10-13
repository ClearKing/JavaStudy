
import java.util.List;
public interface IStudentDAO {
    /**
     *  保存对象
     * @param stu
     */
    void save(Student stu);

    /**
     * 删除指定的对象
     * @param id
     */
    void delete(Long id);

    /**
     * 更新指定的对象
     * @param id
     * @param newStu
     */
    void update(Long id, Student newStu);

    /**
     * 查询指定的对象
     * @param id
     * @return 如果存在该id,则返回该id
     */
    Student get(Long id);

    /**
     * 查询所有的对象
     * @return 返回所有的对象，如果没有，返回一个空集
     */
    List<Student> list();
}
