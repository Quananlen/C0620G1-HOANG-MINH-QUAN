package BO;

import model.User;

import java.util.ArrayList;
import java.util.List;

public interface IUserBO {
    List<User> getAll();
    void add(User user);
    void delete(String id);
    void edit(int id,User user);
    ArrayList<User> searchAddress(String address);
    ArrayList<User> sortByName();
    ArrayList<User> searchID(String id);
    void addUserPermission();
    void insertUpdateWithoutTransaction();
}
