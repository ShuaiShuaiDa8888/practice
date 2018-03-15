import model.Student;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import searchVO.StudentSearchVO;
import utils.DBHelper;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by weishuai on 2018/2/13.
 */
public class TestOfSelectByJDBC {

    private final static Logger logger = LoggerFactory.getLogger(TestOfSelectByJDBC.class);

    private DBHelper dbHelper;
    private StudentSearchVO studentSearchVO;
    private SelectByJDBC selectByJDBC;
    String sql = "SELECT * FROM students WHERE 1=1 AND id = ?";

    @Before
    public void init() {
        studentSearchVO = new StudentSearchVO();
        selectByJDBC = new SelectByJDBC();
    }

    @Test
    public void selectByJDBC() throws Exception {
        try {
            dbHelper = new DBHelper(sql);
            List<Student> studentList = selectByJDBC.listTable(Student.class, dbHelper, studentSearchVO, sql);
            logger.info("info");
            logger.error("查询条件为：id:"+studentSearchVO.getId()+",name:"+studentSearchVO.getName());
            if (null == studentList) {
                logger.error("studentList集合为空");
            }
            System.out.println(studentList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
