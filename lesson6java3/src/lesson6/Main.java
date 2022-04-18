package lesson6;
import java.sql.*;
public class Main {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {

        try{
            connect();
            createTable();                  // Формируем таблицу студентов
            clearTable();
            preparedStatementBatchData();   // и заполняем ее 10 записями
            disconnect();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){

        }finally{
            disconnect();
        }
    }

    public static void createTable() throws SQLException{
        statement.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY AUTOINCREMENT, studid INTEGER, name TEXT, score INTEGER);");
    }


    public static void clearTable() throws SQLException{
        statement.execute("DELETE FROM students;");
    }


    public static void preparedStatementBatchData() throws SQLException {
        connection.setAutoCommit(false);
        preparedStatement = connection.prepareStatement("INSERT INTO students(studid, name, score) VALUES (?,?,?);");
        int kMin = 1;
        int kMax = 10;
        for (int i = kMin; i <= kMax; i++) {
            preparedStatement.setInt(1, (i));
            preparedStatement.setString(2, "name" + i);
            preparedStatement.setInt(3, (i * 10));
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.commit(); //завершаем тразакцию в БД
    }


    public static void connect() throws SQLException, ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:jcorepro6.db");
        statement = connection.createStatement();
    }


    public static void disconnect(){
        try{
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
