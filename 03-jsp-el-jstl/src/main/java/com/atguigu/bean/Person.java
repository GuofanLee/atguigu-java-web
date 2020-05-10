package com.atguigu.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-10 22:22
 */
public class Person {

    private int age;
    private String[] hobby;
    private List<String> address;
    private Map<String, String> params;

    public Person() {}

    public Person(int age, String[] hobby, List<String> address, Map<String, String> params) {
        this.age = age;
        this.hobby = hobby;
        this.address = address;
        this.params = params;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                ", address=" + address +
                ", params=" + params +
                '}';
    }

}
