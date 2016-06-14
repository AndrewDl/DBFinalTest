import java.sql.*;

/**
 * Created by Andrew on 06/10/16.
 */
public class DB_Students {

    public static String DB_NAME = "jdbc:mysql://localhost:3306/Group";
    public  static String DB_USER = "mysql";
    public  static String DB_PASSWORD = "mysql";

    public static void DB_INSERT(String name, double mark){
        String query = "INSERT INTO Students (name,mark) VALUES (?,?)";

        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
            statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setDouble(2,mark);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(statement!=null){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void DB_DELETE(int id){
        String query = "DELETE FROM Students WHERE id=?";
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(statement!=null){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void DB_SELECT(){
        String query = "SELECT * FROM Students";
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            System.out.println("id" + "    " + "name" + "    " + "mark");
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String Name = resultSet.getString(2);
                double Mark = resultSet.getDouble(3);
                System.out.println(id + "    " + Name + "    " + Mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(statement!=null){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void DB_SELECT(double mark){
        String query = "SELECT * FROM Students WHERE mark=?";
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
            statement = connection.prepareStatement(query);
            statement.setDouble(1, mark);
            resultSet = statement.executeQuery();
            System.out.println("id" + "    " + "name" + "    " + "mark");
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String Name = resultSet.getString(2);
                double Mark = resultSet.getDouble(3);
                System.out.println(id + "    " + Name + "    " + Mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(statement!=null){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static boolean DB_SELECT(String name){
        boolean flag = false;
        String query = "SELECT id FROM Students WHERE name=?";
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(statement!=null){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
    public static void DB_UPDATE(String name, double mark){
        String query = "UPDATE Students SET mark=? WHERE name=?";
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
            statement = connection.prepareStatement(query);
            statement.setString(2,name);
            statement.setDouble(1,mark);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(statement!=null){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}

