package Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
    public static ArrayList<Customer> arrCustomer = new ArrayList<>();

    private String name;
    private String birthday;
    private String gender;
    private String id;
    private int phoneNum;
    private String email;
    private String address;
    Services service;

    public Customer() {
    }

    public Customer(String name, String birthday, String gender, String id, int phoneNum, String email, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id = id;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public String showInfo() {
        if (service == null) return "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", phoneNum=" + phoneNum +
                ", email='" + email + '\'' +
                ", address='" + address + '\'';

        return "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", phoneNum=" + phoneNum +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", service={" + service.showInfo() + '}';
    }


}
