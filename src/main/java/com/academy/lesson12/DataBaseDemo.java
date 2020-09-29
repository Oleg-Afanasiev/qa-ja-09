package com.academy.lesson12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseDemo {
    private static Logger LOG = LogManager.getLogger(DataBaseDemo.class.getName());

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/demo?user=root&password=root&serverTimezone=UTC";

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
}

