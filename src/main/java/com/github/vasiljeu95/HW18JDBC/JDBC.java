package com.github.vasiljeu95.HW18JDBC;

import java.sql.*;

public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/plant";
    private static final String USER = "root";
    private static final String PASSWORD = "root1234";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("База данных успешно подключена!");

            Statement statement = connection.createStatement();

            String sqlRequestFirst = "SELECT * FROM employee WHERE department_id IS NULL";
            resultSQLRequest(statement, sqlRequestFirst);

            String sqlRequestSecond = "SELECT * FROM employee WHERE salary>(SELECT avg(salary) FROM employee)";
            resultSQLRequest(statement, sqlRequestSecond);

            statement.close();
        } catch (SQLException e) {
            System.out.println("База данных подключена не успешно!");
            e.printStackTrace();
        }
    }

    private static void resultSQLRequest(Statement statement, String sqlRequestSecond) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sqlRequestSecond);

        while (resultSet.next()) {
            long id = resultSet.getLong("client_id");
            String name = resultSet.getString("name");
            int salary = resultSet.getInt("salary");
            int department_id = resultSet.getInt("department_id");

            System.out.printf("id: %d, name: %s, salary: %s, department_id: %s\n",
                    id, name, salary, department_id);
        }

        resultSet.close();
    }
}
