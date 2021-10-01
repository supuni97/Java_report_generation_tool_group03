import java.sql.*;
import java.util.ArrayList;

public class ReadTable1 {

    String date1;
    String date2;
    String table;

    public ReadTable1(String date1, String date2, String table){
        this.date1 =  date1;
        this.date2 = date2;
        this.table = table;
    }

    public ResultSet dataSet() {
        ResultSet resultSet = null;
        String url = "jdbc:mysql://localhost:3306/e-comece";
        String userName = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM "+table+" WHERE date BETWEEN '"+date1+"' AND '"+date2+"'");

        }catch (Exception e){
            System.out.println(e);
        }
        return resultSet;
    }
}
