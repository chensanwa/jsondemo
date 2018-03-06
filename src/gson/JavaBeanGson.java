package gson;

import java.util.Date;
import java.util.List;

/**
 * @program: jsondemo
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-06 12:51
 **/
public class JavaBeanGson {
    private String name;

    private String school;
    private boolean has_girlfriend;
    private double age;
    private Object car;
    private Object house;
    private List<String> major;     //Gson中无缝对接集合类型
    private String comment;
    private Date birthday;

    private transient String ignore;        //在Json生成中忽略掉该属性

    public JavaBeanGson(){

    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public boolean isHas_girlfriend() {
        return has_girlfriend;
    }

    public double getAge() {
        return age;
    }

    public Object getCar() {
        return car;
    }

    public Object getHouse() {
        return house;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getComment() {
        return comment;
    }

    public String getSchool() {
        return school;
    }

    public List<String> getMajor() {
        return major;
    }

    public void setCar(Object car) {
        this.car = car;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setHas_girlfriend(boolean has_girlfriend) {
        this.has_girlfriend = has_girlfriend;
    }

    public void setHouse(Object house) {
        this.house = house;
    }

    public void setMajor(List<String> major) {
        this.major = major;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
