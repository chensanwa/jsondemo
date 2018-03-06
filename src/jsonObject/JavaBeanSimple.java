package jsonObject;

import com.google.gson.annotations.SerializedName;

/**
 * @program: jsondemo
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-06 09:37
 **/
public class JavaBeanSimple {

//    @SerializedName("NAME")
    private String name;

    private String school;
    private boolean has_girlfriend;
    private double age;
    private Object car;
    private Object house;
    private String [] major;
    private String comment;
    private String birthday;

    private transient String ignore;        //在Json生成中忽略掉该属性

    public JavaBeanSimple(){

    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }

    public void setBirthday(String birthday) {
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

    public String getBirthday() {
        return birthday;
    }

    public String getComment() {
        return comment;
    }

    public String getSchool() {
        return school;
    }

    public String[] getMajor() {
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

    public void setMajor(String[] major) {
        this.major = major;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
