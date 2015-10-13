package GsonTest1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/10/13.
 */
public class GsonTest1 {

    public static void main(String[] args) {

        Gson gson = new Gson();

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("大大大大大臣哥");
        student1.setBirthDay(new Date());

        //JavaBean转化Json===
        String student_json = gson.toJson(student1);
        System.out.println("JavaBean转化Json===" + student_json);

        //Json转化JavaBean
        Student student = gson.fromJson(student_json, Student.class);
        System.out.println("Json转化为JavaBean===" + student);

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("张三");
        student2.setBirthDay(new Date());

        Student student3 = new Student();
        student3.setId(2);
        student3.setName("李四");
        student3.setBirthDay(new Date());

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        System.out.println("----------带泛型的List之间的转化-------------");

        // 带泛型的list转化为json
        String s = gson.toJson(studentList);
        System.out.println("带泛型的list转化为json===" + s);

        List<Student> retList = gson.fromJson(s, new TypeToken<List<Student>>() {
        }.getType());

        for (Student student4 : retList) {
            System.out.println(student4);
        }
    }
}
