import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    BaseDAO baseDAO = new BaseDAO();
    Connection connection = baseDAO.getConnection();


    public ArrayList<User> displayAll() {
        ArrayList<User> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from user"
            );
            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                String phone = resultSet.getString("phone");
                list.add(new User(name, department, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
