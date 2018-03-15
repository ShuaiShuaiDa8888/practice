import model.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import searchVO.StudentSearchVO;
import utils.DBHelper;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 查看Student表中信息（所有）
 *
 * Created by weishuai on 2018/2/13.
 */
public class SelectByJDBC {
    public static ResultSet rs = null;

    public List<Student> listTable(Class<Student> clazz, DBHelper dbHelper, StudentSearchVO studentSearchVO, String sql) throws Exception {
        List<Student> studentList = null;
        try {
            dbHelper = new DBHelper(sql);
            studentSearchVO.setId(1);
            dbHelper.ps.setInt(1, studentSearchVO.getId());
            rs = dbHelper.ps.executeQuery();
            if (rs != null) {
                List<String> columnLabels = getColumnLabels(rs);
                if (columnLabels != null && columnLabels.size() > 0){
                    studentList = new ArrayList<>();
                    while (rs.next()){
                        Student instance = resultSet2Bean(clazz, columnLabels, rs);
                        studentList.add(instance);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    /**
     * 获取 ResultSet 结果集中所有字段的集合
     *
     * @param resultSet: 结果集
     * @return : 查询字段的集合
     */
    private static List<String> getColumnLabels(ResultSet resultSet) {
        List<String> labels = new ArrayList<>();
        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                String columnLabel = resultSetMetaData.getColumnLabel(i + 1);
                String columnName = resultSetMetaData.getColumnName(i + 1);
                if (StringUtils.isNotEmpty(columnLabel)) {
                    labels.add(columnLabel);
                } else {
                    labels.add(columnName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return labels;
    }

    private static <Student>Student resultSet2Bean(Class<Student> clazz, List<String> columnLabels, ResultSet resultSet) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Student instance = clazz.newInstance();
        for (String columnLabel : columnLabels) {
            Object columnValue = null;
            try {
                columnValue = resultSet.getObject(columnLabel);
                if (columnValue != null) {
                    BeanUtils.setProperty(instance, columnLabel, columnValue);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
