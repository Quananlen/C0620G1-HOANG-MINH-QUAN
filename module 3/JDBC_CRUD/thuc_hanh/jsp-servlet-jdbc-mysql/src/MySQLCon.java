import java.sql.*;


public class MySQLCon {
    public static void main(String[] args) throws SQLException {
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/furama_resort","root","codegym");
//here sonoo is database name, root is username and password
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from customer");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        con.close();
    }
}
