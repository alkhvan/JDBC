package de.telekom.jdbcchallenge;

import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;

import static java.sql.DriverManager.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        final String URL = "jdbc:mysql://localhost:3306/seadb?user=seauser&password=seapass";
        try {
            Connection connection = getConnection(URL);
            Statement statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into personen (ID, SALUTATION, NAME, SURNAME) values (?,?,?,?)");
            String requestSelect = "select * from personen";
            Scanner scanner = new Scanner(System.in);
            System.out.println("ID: ");
            long id = Long.parseLong(scanner.nextLine());
            System.out.println("Salutation: ");
            short salutation = Short.parseShort(scanner.nextLine());
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("Surname: ");
            String surname = scanner.nextLine();


            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, salutation);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, surname);

            preparedStatement.executeQuery( requestSelect);
            ResultSet resultSet = statement.executeQuery( requestSelect);
            while(resultSet.next()) {
                System.out.println("ID: "+ resultSet.getLong(1));
                System.out.println("Salutation: "+ resultSet.getLong(2));
                System.out.println("Name: "+ resultSet.getString(3));
                System.out.println("Surname: "+ resultSet.getString(4));
            }


            while (resultSet.next()){
                System.out.println("ID: "+ resultSet.getLong(1));
                System.out.println("Salutation: "+ resultSet.getLong(2));
                System.out.println("Name: "+ resultSet.getString(3));
                System.out.println("Surname: "+ resultSet.getString(4));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

