package com.itcase.domain;

/**
 * @创建人 kzp
 * @创建时间
 * @描述
 */
public class User {
    private Integer uid;
    private String name;
    private String gender;

    public User(){
    }

    public User(Integer uid, String name, String gender){
        this.uid = uid;
        this.name = name;
        this.gender = gender;
    }

    public Integer getUid(){
        return uid;
    }

    public void setUid(Integer uid){
        this.uid = uid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
