package DAO;

import model.User;

import java.util.ArrayList;

public interface IUserDAO {
    void delete(String id);
    ArrayList<User> getAll();
    void add(User user);
    void edit(int id, User user);
    ArrayList<User> searchAddress(String address);
    ArrayList<User> sortByName();
    ArrayList<User> searchID(String id);
    void addUserTransaction(User user, int[] permissions);
    void insertUpdateWithoutTransaction();
}
