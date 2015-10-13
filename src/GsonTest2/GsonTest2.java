package GsonTest2;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/10/13.
 */
public class GsonTest2 {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()//导出实体中使用了@Expose注解的字段
                .enableComplexMapKeySerialization()//支持Map的key为复杂对象的形式
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
                .setPrettyPrinting()//对json结果格式化.
                .setVersion(1.0)//有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                .create();

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("大大大大大臣哥");
        student1.setBirthDay(new Date());

        //JavaBean转化为json
        String student_json = gson.toJson(student1);
        System.out.println(student_json);


        //Json转化为Bean
        Student json_student = gson.fromJson(student_json, Student.class);
        System.out.println(json_student);

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("曹贵生");
        student2.setBirthDay(new Date());

        Student student3 = new Student();
        student3.setId(3);
        student3.setName("柳波");
        student3.setBirthDay(new Date());

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        String Students = gson.toJson(studentList);
        System.out.println(Students);

        List<Student> s = gson.fromJson(Students, new TypeToken<List<Student>>() {
        }.getType());
        System.out.println(s);
    }
}
