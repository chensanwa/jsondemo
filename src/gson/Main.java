package gson;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jsonObject.JavaBeanSimple;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @program: jsondemo
 * @description: GSON demo
 * @author: Mr.Chen
 * @create: 2018-03-06 12:34
 **/
public class Main {

    @Test
    //生成JSON数据
    public void createJsonByGson(){
        JavaBeanSimple wangxiaoer = new JavaBeanSimple();
        wangxiaoer.setAge(23);
        wangxiaoer.setBirthday("12334");
        wangxiaoer.setCar(null);
        wangxiaoer.setComment("this is a comment");
        wangxiaoer.setHas_girlfriend(false);
        wangxiaoer.setHouse(null);
        wangxiaoer.setName("wangxiaoer");
        wangxiaoer.setMajor(new java.lang.String[]{"理发","wajuej"});
        wangxiaoer.setSchool("xhu");
        wangxiaoer.setIgnore("忽略掉的属性");

        //利用GsonBuilder进行操作
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();        //格式化

        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
                //修改name为NAME
                if(field.getName().equals("name")){
                    return "NAME";
                }
                return field.getName();
            }
        });

//        Gson gson = new Gson();
        Gson gson = gsonBuilder.create();

        String jsonObject = gson.toJson(wangxiaoer);
        System.out.println(jsonObject);
    }


    @Test
    //在文件中进行解析JSON数据
    public void getJsonByFile() throws IOException {

        File file = new File("F:\\Javaweb\\demo\\jsondemo\\src\\jsonObject\\people.json");
        java.lang.String content = FileUtils.readFileToString(file);

        Gson gson = new Gson();

        //蒋数据解析为JavaBean
        JavaBeanSimple wangxiaoer = gson.fromJson(content,JavaBeanSimple.class);
        System.out.println(wangxiaoer.getName());
    }

    @Test
    //测试GSON中对于日期类的支持测试
    public void birthdayGson() throws Exception{
        File file = new File("F:\\Javaweb\\demo\\jsondemo\\src\\jsonObject\\people.json");
        java.lang.String content = FileUtils.readFileToString(file);

//        Gson gson = new Gson();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        //蒋数据解析为JavaBean
        JavaBeanGson wangxiaoer = gson.fromJson(content,JavaBeanGson.class);
        System.out.println(wangxiaoer.getName());
        System.out.println(wangxiaoer.getBirthday().toLocaleString());


        //测试GSON中对于集合类的实现测试
        System.out.println(wangxiaoer.getMajor());
        System.out.println(wangxiaoer.getMajor().getClass());
    }
}
