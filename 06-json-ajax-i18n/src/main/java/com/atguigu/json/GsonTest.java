package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-16 17:01
 */
public class GsonTest {

    /**
     * Java Bean 和 Json 字符串互转
     */
    @Test
    public void test1() {
        Gson gson = new Gson();
        Person person = new Person(1, "tom");
        //Java Bean 转为 Json 字符串
        String jsonStr = gson.toJson(person);
        System.out.println(jsonStr);
        //Json 字符串转为 Java Bean
        Person fromJson = gson.fromJson(jsonStr, Person.class);
        System.out.println(fromJson);
    }

    /**
     * List 和 Json 字符串互转
     */
    @Test
    public void test2() {
        Gson gson = new Gson();
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "tom"));
        personList.add(new Person(2, "jack"));
        //List 转为 Json 字符串
        String jsonStr = gson.toJson(personList);
        System.out.println(jsonStr);
        //Json 字符串转为 List
        List<Person> persons = gson.fromJson(jsonStr, new TypeToken<ArrayList<Person>>(){}.getType());
        System.out.println(persons);
        System.out.println(persons.get(0));
    }

    /**
     * Map 和 Json 字符串互转
     */
    @Test
    public void test3() {
        Gson gson = new Gson();
        Map<Integer, Person> map = new HashMap<>();
        map.put(1, new Person(1, "tom"));
        map.put(2, new Person(2, "jack"));
        //Map 转为 Json 字符串
        String jsonStr = gson.toJson(map);
        System.out.println(jsonStr);
        //Json 字符串转为 Map
        Map<Integer, Person> fromJson = gson.fromJson(jsonStr, new TypeToken<HashMap<Integer, Person>>(){}.getType());
        System.out.println(fromJson);
        System.out.println(fromJson.get(1));
    }

}
