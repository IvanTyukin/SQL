import java.sql.*;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public  static final  String USER_NAME = "root";
    public  static final  String PASSWORD = "*";
    public  static final  String URL = "jdbc:mysql://localhost:3306/mysql";
    public  static Statement statement;
    public  static Connection connection;

    private static final  String SQL = "DELETE FROM testsystem.teacher" +
            " WHERE idteacher = 2";


    static  {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws  ClassNotFoundException, SQLException, IOException {


            try (Connection connection = DriverManager.getConnection(URL,USER_NAME, PASSWORD); Statement statement = connection.createStatement() ) {
                Scanner sc = new Scanner(System.in);
                int SQLQuery = statement.executeUpdate(sc.nextLine());
                System.out.println(SQLQuery);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            ResultSet resultSet = statement.executeQuery("SELECT * FROM testsystem.teacher");



//            try (Connection connection =DriverManager.getConnection(URL,USER_NAME,PASSWORD) ; Statement statement=connection.createStatement() ) {
//                 int resultSet1 = statement.executeUpdate("UPDATE testsystem.teacher SET name='Надежда' WHERE idteacher=2");
//                 System.out.println(resultSet1);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }


            System.out.println(" _____________________________________________________________________");

            while (resultSet.next()) {
                System.out.printf(" | %-15s | %-15s | %-15s | %-4s | %-4s |\n" , resultSet.getString(2)  ,
                        resultSet.getString(3)  ,
                        resultSet.getString(4)  ,
                        resultSet.getString(5)  ,
                        resultSet.getString(6));
            }
            System.out.println(" ---------------------------------------------------------------------");



                    //          УДАЛЕНИЕ

//            try (Connection connection = DriverManager.getConnection(
//                    URL, USER_NAME, PASSWORD);
//                 Statement statement = connection.createStatement()) {
//
//                System.out.println("Выполняем запрос:");
//                System.out.println(SQL);
//
//                statement.executeUpdate(SQL);
//
//                System.out.println("Запрос на удаление данных выполнен.");
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }

        //                      ДОБАВЛЕНИЕ

//        try (Connection connection =DriverManager.getConnection(URL,USER_NAME,PASSWORD) ; Statement statement=connection.createStatement() ) {
//            int resultSet1 = statement.executeUpdate("INSERT INTO testsystem.teacher (surname, name, patronymic, experience, gender,idteacher)" + "VALUES ('Романко', 'Надежда', 'Андреевна', 6, 'ж',2)");
//            System.out.println(resultSet1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }




        statement.close();
        connection.close();
    }

}
