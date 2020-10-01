package DAO;

import model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserDAO implements IUserDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private Connection connection = baseDAO.getConnection();
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " CREATED_DATE timestamp,"
            + " PRIMARY KEY (ID)"
            + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> userList = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall("call displayAll()");
            ResultSet resultSet = callableStatement.executeQuery();
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

//        try {
//            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement("select * from user");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Integer id = Integer.valueOf(resultSet.getString("id"));
//                String name = resultSet.getString("name");
//                String birthday = resultSet.getString("birthday");
//                int gender = Integer.parseInt(resultSet.getString("gender"));
//                String phone = resultSet.getString("phone");
//                String idCard = resultSet.getString("id_card");
//                String email = resultSet.getString("email");
//                String address = resultSet.getString("address");
//                User user = new User(id, name, birthday, gender, idCard, phone, email, address);
//                userList.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return userList;
    }

    @Override
    public void add(User user) {
        try {
            CallableStatement callableStatement = baseDAO.getConnection().prepareCall(
                    "call insertUser(?,?,?,?,?,?,?)"
            );
            String[] list = {user.getName(), user.getBirthday(), String.valueOf(user.getGender()), user.getPhone(), user.getIdCard(), user.getEmail(), user.getAddress()};
            for (int i = 0; i < list.length; i++) {
                callableStatement.setString(i + 1, list[i]);
            }
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(
//                    "insert into user (name, birthday, gender, phone, id_card, email, address)\n" +
//                            "value (?,?,?,?,?,?,?)"
//            );
//
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getBirthday());
//            preparedStatement.setString(3, String.valueOf(user.getGender()));
//            preparedStatement.setString(4, user.getPhone());
//            preparedStatement.setString(5, user.getIdCard());
//            preparedStatement.setString(6, user.getEmail());
//            preparedStatement.setString(7, user.getAddress());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void edit(int id, User user) {
        try {
            CallableStatement callableStatement = connection.prepareCall("call editUser(?,?,?,?,?,?,?,?)");
            String[] list = {user.getName(), user.getBirthday(), String.valueOf(user.getGender()), user.getPhone(), user.getIdCard(), user.getEmail(), user.getAddress(), String.valueOf(id)};
            for (int i = 0; i < list.length; i++) {
                callableStatement.setString(i + 1, list[i]);
            }
            callableStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            PreparedStatement preparedStatement;
//            preparedStatement = this.baseDAO.getConnection().prepareStatement(
//                    "update user \n" +
//                            "set name = (?), birthday = (?), gender = (?), phone = (?), id_card = (?), email=(?), address = (?) \n" +
//                            "where id = (?);"
//            );
//            preparedStatement.setString(1, String.valueOf(user.getName()));
//            preparedStatement.setString(2, user.getBirthday());
//            preparedStatement.setString(3, String.valueOf(user.getGender()));
//            preparedStatement.setString(4, user.getPhone());
//            preparedStatement.setString(5, user.getIdCard());
//            preparedStatement.setString(6, user.getEmail());
//            preparedStatement.setString(7, user.getAddress());
//            preparedStatement.setString(8, String.valueOf(id));
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
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
    public ArrayList<User> searchID(String inputID) {
        ArrayList<User> userList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseDAO.getConnection().prepareCall(
                    "call findByID(?)"
            );
            callableStatement.setString(1, inputID);
            ResultSet resultSet = callableStatement.executeQuery();
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
    public void addUserTransaction(User user, int[] permissions) {
        try {
            baseDAO.getConnection().setAutoCommit(false);
            String insertUserSLQ = "insert into user(name, birthday, gender, phone, id_card, email, address) value(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = baseDAO.getConnection().prepareStatement(insertUserSLQ, Statement.RETURN_GENERATED_KEYS);
            String[] list = {user.getName(), user.getBirthday(), String.valueOf(user.getGender()), user.getPhone(), user.getIdCard(), user.getEmail(), user.getAddress()};
            for (int i = 0; i < list.length; i++) {
                preparedStatement.setString(i + 1, list[i]);
            }
            int rowAffected = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int userId = 0;
            if (resultSet.next()) userId = resultSet.getInt(1);
            if (rowAffected == 1) {
                PreparedStatement preparedStatementAssignment = baseDAO.getConnection().prepareStatement(
                        "INSERT INTO user_permission(user_id,permission_id) VALUES(?,?)"
                );
                for (int permissionId : permissions) {
                    preparedStatementAssignment.setInt(1, userId);
                    preparedStatementAssignment.setInt(2, permissionId);
                    preparedStatementAssignment.executeUpdate();
                }
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            try {
                if (baseDAO.getConnection() != null) connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try (Statement statement = connection.createStatement();
             PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
             PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE)) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);
            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            //below line caused error, test transaction
            psUpdate.setBigDecimal(2, new BigDecimal("999.99"));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            CallableStatement callableStatement = connection.prepareCall("call deleteUser(?)");
            callableStatement.setString(1, id);
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(
//                    "delete from user " +
//                            "where id = (?)");
//            preparedStatement.setString(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
