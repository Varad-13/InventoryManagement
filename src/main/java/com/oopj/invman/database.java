package com.oopj.invman;

import java.sql.*;

public class database {
    private static final String DATABASE_URL = "jdbc:mysql://database-1.cj5xtfkwqhiq.ap-south-1.rds.amazonaws.com/mini_project";
    private static final String DATABASE_USERNAME = "admin";
    private static final String DATABASE_PASSWORD = "genius123";
    private static final String INSERT_ITEM = "INSERT INTO items (barCode, itemName, MRP) VALUES (?, ?, ?)";
    private static final String GET_ITEM = "SELECT * FROM items WHERE barCode = ?";
    static int mrp;
    static String item;

    public Connection connectDatabase() {
        try {
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQL Connection fail!");
        }
        return null;
    }

    public void getItem(String x) throws SQLException {
        try (Connection connection = connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ITEM)) {
            preparedStatement.setString(1, x);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                database.mrp = resultSet.getInt("MRP");
                database.item = resultSet.getString("itemName");
            }
        }
    }
    public void insertItem(String barCode, String name, int mrp) throws SQLException {
        try (Connection connection = connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ITEM)){
            preparedStatement.setString(1, barCode);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, mrp);
            preparedStatement.executeUpdate();
        }
    }
}
