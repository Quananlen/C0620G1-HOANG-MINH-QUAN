package DAO;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements IUserDAO {
    private BaseDAO baseDAO = new BaseDAO();

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement("select * from user");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = Integer.valueOf(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                int gender = Integer.parseInt(resultSet.getString("gender"));
                String phone = resultSet.getString("phone");
                String idCard = resultSet.getString("id_card");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                User user = new User(id, name, birthday, gender, idCard, phone, email, address);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void add(User user) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(
                    "insert into user (name, birthday, gender, phone, id_card, email, address)\n" +
                            "value (?,?,?,?,?,?,?)"
            );

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getBirthday());
            preparedStatement.setString(3, String.valueOf(user.getGender()));
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getIdCard());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(int id, User user) {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = this.baseDAO.getConnection().prepareStatement(
                    "update user \n" +
                            "set name = (?), birthday = (?), gender = (?), phone = (?), id_card = (?), email=(?), address = (?) \n" +
                            "where id = (?);"
            );
            preparedStatement.setString(1, String.valueOf(user.getId()));
            preparedStatement.setString(2, user.getBirthday());
            preparedStatement.setString(3, String.valueOf(user.getGender()));
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getIdCard());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setString(8, String.valueOf(id));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> searchAddress(String address) {
        ArrayList<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(
                    "select * from user where address = ?"
            );
            preparedStatement.setString(1, address);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = Integer.valueOf(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                int gender = Integer.parseInt(resultSet.getString("gender"));
                String phone = resultSet.getString("phone");
                String idCard = resultSet.getString("id_card");
                String email = resultSet.getString("email");
                User user = new User(id, name, birthday, gender, idCard, phone, email, address);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public ArrayList<User> sortByName() {
        ArrayList<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(
                    "select * from user order by name"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = Integer.valueOf(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                int gender = Integer.parseInt(resultSet.getString("gender"));
                String phone = resultSet.getString("phone");
                String idCard = resultSet.getString("id_card");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                User user = new User(id, name, birthday, gender, idCard, phone, email, address);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void delete(String id) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(
                    "delete from user " +
                            "where id = (?)");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
