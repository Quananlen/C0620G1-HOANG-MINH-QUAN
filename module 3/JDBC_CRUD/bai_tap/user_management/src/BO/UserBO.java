package BO;

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

    @Override
    public ArrayList<User> searchID(String id) {
        return userDAO.searchID(id);
    }

    @Override
    public void addUserPermission() {
        User user = new User("Nguyễn Văn Khánh", "1997-03-31", 1, "321454769", "2319183198", "qazz.iiz.1j@petruhino2.ru", "Da Nang");
        int[] permission = {1, 2, 4};
        userDAO.addUserTransaction(user, permission);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        userDAO.insertUpdateWithoutTransaction();
    }
}
