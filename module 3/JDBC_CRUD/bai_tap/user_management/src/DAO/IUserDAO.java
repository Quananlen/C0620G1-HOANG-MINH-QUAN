package DAO;

import model.User;

import java.util.ArrayList;

public interface IUserDAO {
    void delete(String id);
    ArrayList<User> getAll();
    void add(User user);
}
