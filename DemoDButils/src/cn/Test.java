package cn;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        TeacherDao sd = new TeacherDao();

        // 添加数据库测试
        sd.addTeacher("王德峰1",1);
        sd.addTeacher("王德峰",2);
        sd.addTeacher("周作人3",3);
        sd.addTeacher("老舍4",4);
        sd.addTeacher("毛泽东5",5);

        System.out.println("成功");

        // 更新数据库测试
        sd.updateTeacher("王德峰2", 3);
		System.out.println("成功");



        System.out.println("成功");

        // 删除数据库测试
        sd.deleteTeacher(4);
		System.out.println("成功");

        // 查询所有测试
        List<Teacher> list = sd.queryAll();
        for (Teacher s : list) {
            System.out.println(s);
        }

        // 根据ID查询学生 测试
        Teacher s = sd.getTeacherById(3);
        System.out.println(s);
    }
}
