package BO;

import model.User;

import java.util.ArrayList;
import java.util.List;

public interface IUserBO {
    List<User> getAll();
    void add(User user);
    void delete(String id);
}
