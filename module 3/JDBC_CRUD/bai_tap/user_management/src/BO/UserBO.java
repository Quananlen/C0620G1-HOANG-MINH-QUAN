package BO;

import DAO.BaseDAO;
import DAO.UserDAO;
import model.User;

import java.util.ArrayList;

public class UserBO implements IUserBO {

    private UserDAO userDAO = new UserDAO();

    @Override
    public ArrayList<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(String id) {
        userDAO.delete(id);
    }

    @Override
    public void edit(int id, User user) {
        userDAO.edit(id, user);
    }

    @Override
    public ArrayList<User> searchAddress(String address) {
        return userDAO.searchAddress(address);
    }

    @Override
    public ArrayList<User> sortByName() {
        return userDAO.sortByName();
    }
}
