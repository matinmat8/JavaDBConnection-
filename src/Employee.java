import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Employee {

    // attributes
    private int ID;
    private int Age;
    private int Salary;


    private static float Avg;

    public void Employee(){

    }

   public void Set_info(int i, int a, int s) throws SQLException {
       String sql = "INSERT INTO employee (id, age, salary) VALUES (?, ?, ?)";
       var connection = DatabaseConfig.connect();
       try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
           preparedStatement.setInt(1, i);
           preparedStatement.setInt(2, a);
           preparedStatement.setInt(3, s);
           int rowsInserted = preparedStatement.executeUpdate();
                System.out.println(rowsInserted + " row(s) inserted.");
       } catch (SQLException e) {
            e.printStackTrace();
        }
   }

   // Getting info based on emplyee information

   public String Get_info(int id) throws SQLException {
        String QUERY = "SELECT * FROM employee WHERE id =?";
        var connection = DatabaseConfig.connect();
        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
           preparedStatement.setInt(1, id);
           ResultSet resultSet = preparedStatement.executeQuery();
           resultSet.next();
           ID = resultSet.getInt("id");
           Age = resultSet.getInt("age");
           Salary = resultSet.getInt("salary");

       } catch (SQLException e) {
            e.printStackTrace();
        }
        return "ID: " + ID + " age: " + Age + " salary: " + Salary;
   }
}
