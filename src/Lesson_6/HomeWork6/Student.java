package Lesson_6.HomeWork6;

import java.sql.*;

public class Student implements AutoCloseable {

    private final Connection connection;

    public Student(String dbUrl) {
        connectDriver();
        this.connection = createConnection(dbUrl);
    }

    private Connection createConnection(String dbUrl) {
        try {
            return DriverManager.getConnection("jdbc:sqlite:" + dbUrl);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Invalid database URL: " + dbUrl);
        }
    }

    private void connectDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to find JDBC driver", e);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public boolean insertMark(String fam, int mark) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Marks (NAME, MARK) " +
                    "VALUES ('" + fam + "', '" + mark + "')");
            if (statement.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getMarkById(int id) {
        int mark = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MARK FROM Marks WHERE ID = '" + id + "'");
            while (resultSet.next()) {
                mark = resultSet.getInt("MARK");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
        return mark;
    }

    public boolean changeMarkById(int id, int newMark) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Marks SET MARK = '" + newMark +
                    "' WHERE ID = '" + id + "'");
            if (statement.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
