package com.academy.lesson12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Random;

public class DataBaseDemo {
    private static Logger LOG = LogManager.getLogger(DataBaseDemo.class.getName());
    private static String url = "jdbc:mysql://localhost:3306/demo?user=root&password=root&serverTimezone=UTC";

    public static void main(String[] args) {
        prepareStatementSample();
    }

    private static void statementSample() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            // вставка
            statement.execute("insert into abonent " +
                    "(first_name, last_name, gender, age)" +
                    "values " +
                    "('TestName','Ivanov', 'm', 44)");

            // чтение из БД
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ABONENT");

            while (resultSet.next()) { // указатель на следующую строку
                String name = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                Integer age = resultSet.getInt("age");

                System.out.println(name + ":" + lastName + ":" + gender + ":" + age);
            }
            resultSet.close();
            connection.close();

        } catch (Exception e) {
            LOG.error(e);
        }
    }

    private static void prepareStatementSample() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into abonent " +
                    " (first_name, last_name, gender, age)" +
                    " values " +
                    " (?, ?, ?, ?)");
            for (int i = 1; i <= 10; i++) {
                preparedStatement.setString(1, randomName());
                preparedStatement.setString(2, "Ivanov");
                preparedStatement.setString(3, "m");
                preparedStatement.setInt(4, 22+i);
                preparedStatement.execute();
            }
            // вставка
//            statement.execute("insert into abonent " +
//                    "(first_name, last_name, gender, age)" +
//                    "values " +
//                    "('TestName','Ivanov', 'm', 44)");


            Statement statement = connection.createStatement();
            // чтение из БД
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ABONENT order by abonent_id");

            while (resultSet.next()) { // указатель на следующую строку
                String name = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                Integer age = resultSet.getInt("age");

                System.out.println(name + ":" + lastName + ":" + gender + ":" + age);
            }
            resultSet.close();
            connection.close();

        } catch (Exception e) {
            LOG.error(e);
        }
    }

    private static String randomName() {
        Random random = new Random();
        return "Name_" + random.nextInt();
    }
}

