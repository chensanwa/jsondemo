package jsonObject;

import com.sun.org.apache.xpath.internal.operations.String;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

    
    //直接创建JSON对象
    public void jSONObject(){
        JSONObject wangxiaoer = new JSONObject();
        wangxiaoer.put("name","王小二");
        wangxiaoer.put("age",25.3);
        wangxiaoer.put("birthday","1990-3-4");
        wangxiaoer.put("school","xhu");
//        wangxiaoer.put("major",new String[]{"理发","挖掘机"});

        JSONArray major = new JSONArray();
        major.add("理发");
        major.add("挖掘机");
        wangxiaoer.put("major",major);

        wangxiaoer.put("has_girlfriend",false);
        wangxiaoer.put("car",null);
        wangxiaoer.put("house",null);
        wangxiaoer.put("comment","这是一个注释");
        System.out.println(wangxiaoer.toString());
    }

    //通过Map进行创建JSON对象
    public void createJsonObjectByMap(){
        Map<java.lang.String,Object> wangxiaoer = new HashMap<java.lang.String,Object>();
        wangxiaoer.put("name","王小二");
        wangxiaoer.put("age",25.3);
        wangxiaoer.put("birthday","1990-3-4");
        wangxiaoer.put("school","xhu");
//        wangxiaoer.put("major",new String[]{"理发","挖掘机"});

        JSONArray major = new JSONArray();
        major.add("理发");
        major.add("挖掘机");
        wangxiaoer.put("major",major);

        wangxiaoer.put("has_girlfriend",false);
        wangxiaoer.put("car",null);
        wangxiaoer.put("house",null);
        wangxiaoer.put("comment","这是一个注释");

        JSONObject jsonObject;
        jsonObject = JSONObject.fromObject(wangxiaoer);
        System.out.println(jsonObject.toString());
    }

    @Test
    //通过JavaBean进行创建JSON对象
    public void createJsonObjectByJavabean(){
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

        JSONObject jsonObject = JSONObject.fromObject(wangxiaoer);
        System.out.println(jsonObject);
    }

    @Test
    //在文件中读取数据生成JSON数据
    public void getJsonByFile() throws IOException {
        File file = new File("F:\\Javaweb\\demo\\jsondemo\\src\\jsonObject\\people.json");
        java.lang.String content = FileUtils.readFileToString(file);
        JSONObject jsonObject = JSONObject.fromObject(content);
        System.out.println("name:" + jsonObject.getString("name"));
        System.out.println("age:" + jsonObject.getDouble("age"));
        System.out.println("has_girlfriend:" + jsonObject.getBoolean("has_girlfriend"));
        //读取JSON数组
        JSONArray jsonArray = jsonObject.getJSONArray("major");
        for(int i=0;i<jsonArray.size();i++){
            java.lang.String m = jsonArray.getString(i);
            System.out.println("major" + (i+1) + ":" + m);
        }
    }

}
