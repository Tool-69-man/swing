package cn;

import cn.Teacher;
import cn.Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class TeacherDao {
    private QueryRunner qr;


    /**
     * 创建数据库操作类
     */
    public TeacherDao(){
        qr = new QueryRunner(Util.getDataSource());
    }



    // 添加
    public void addTeacher(String name,int  id)throws Exception{
        String sql = "insert into teacher(id,name) values(?,?)";
        qr.update(sql,id,name);

    }


    // 删除
    public void deleteTeacher(int id)throws Exception{
        String sql = "delete from Teacher where id = ?";
        qr.update(sql  , id);
    }



    // 修改
    public void updateTeacher(String name ,  int id)throws Exception{
        String sql = "update Teacher set name = ?  where id = ?";
        qr.update(sql , name , id);
    }




    // 查询   需要BeanHandler  我下周会讲解这个
    public Teacher getTeacherById(int id) throws Exception{
        String sql = "select * from Teacher where id = ?";
        Teacher result = qr.query(sql, new BeanHandler<>(Teacher.class) , id);
        return result;
    }


    // 查询所有  需要BeanListHandler    我下周会讲解这个
    public List<Teacher> queryAll() throws Exception{
        String sql =  "select * from Teacher";
        return qr.query(sql, new BeanListHandler<>(Teacher.class));
    }
}
