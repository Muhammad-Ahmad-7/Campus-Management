package com.example.login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.sql.*;

public class FileMethods {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost:3306/universityData";
            String userName = "root";
            String passWord = "2392664";
            Class.forName(driver);
            conn = DriverManager.getConnection(dbUrl, userName, passWord);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
        return conn;
    }
    public boolean insertDataEmployeeTable(Employee employee, String type) {
        Connection conn = getConnection();
        if (conn != null) {
            String sql = "INSERT INTO employee (Id, Name, Grade, Type) VALUES (?,?,?,?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                Statement statement = conn.createStatement();
                String query = "CREATE TABLE IF NOT EXISTS employee(" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "Name VARCHAR(50)," +
                        "Grade VARCHAR(50)," +
                        "Type VARCHAR(50)" +
                        ")";
                statement.execute(query);
                preparedStatement.setInt(1, Integer.parseInt(employee.getEmployeeID()));
                preparedStatement.setString(2, employee.getName());
                preparedStatement.setString(3, employee.getGrade());
                preparedStatement.setString(4, type);
                int result = preparedStatement.executeUpdate();
                if (result > 0) {
                    System.out.println("Successfully Inserted");
                } else {
                    System.out.println("Error Occurred");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }

    public boolean insertDataLabTable(Lab lab, String department){
        Connection conn = getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS labdata (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "Name VARCHAR(50)," +
                    "Staff VARCHAR(50)," +
                    "Department VARCHAR(50)" +
                    ")";

            statement.execute(createTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (conn != null ){
            String sql = "insert Into labdata (Name, Staff, Department) values (?,?,?)";
            try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                preparedStatement.setString(2, lab.getLabName());
                preparedStatement.setString(1, lab.getStaffName());
                preparedStatement.setString(3, department);
                int result = preparedStatement.executeUpdate();
                if (result > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e){
                System.out.println("Error In inserting Lab" + e);
            }
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
    public void readNameFromLabTable(ComboBox<String> dropDown){
        Connection conn = getConnection();
        ObservableList<String> labNames = FXCollections.observableArrayList();
        if (conn != null) {
            String sql = "SELECT Name FROM labdata";
            try{
                Statement state = conn.createStatement();
                ResultSet resultSet = state.executeQuery(sql);
                while (resultSet.next()){
                    String name = resultSet.getString("Name");
                    labNames.add(name);
                }
                dropDown.setItems(labNames);
            } catch (Exception e){
                System.out.println(e);
            }
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public boolean insertDataPcTable(Pc pc){
        Connection conn = getConnection();
        if (conn != null) {
            String sql = "insert into pcdata (pcID, Name, Core, Ram, Lcd, Disk, LabName) values (?,?,?,?,?,?,?)";
            try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                preparedStatement.setInt(1,Integer.parseInt(pc.getPcId()));
                preparedStatement.setString(2, pc.getName());
                preparedStatement.setString(3,pc.getCore());
                preparedStatement.setString(4,pc.getRamSize());
                preparedStatement.setString(5,pc.getLcd());
                preparedStatement.setString(6, pc.getDiskSize());
                preparedStatement.setString(7, pc.getLabName());
                int result = preparedStatement.executeUpdate();
                if (result > 0){
                    return true;
                } else {
                    return  false;
                }
            } catch(Exception e){
                System.out.println(e);
            }
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
    public String readEmployeeTable(int id) {
        try {
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee where id = " + id);
            if (resultSet.next()) {
                int employeeId = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String grade = resultSet.getString("Grade");
                String type = resultSet.getString("Type");

                String line = employeeId + " " + name + " " + grade + " " + type;
                return line;
            } else {
                String line = "No Record Found";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String readLabTable(String name){
        try{
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM labdata WHERE name = '" + name + "'");
            if (resultSet.next()){
                String line = resultSet.getInt("id") + " " +resultSet.getString("Name") + " " + resultSet.getString("Staff") + " " +
                        resultSet.getString("Department");
                return line;
            } else {
                return "No Lab Found";
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public String readPcTable(int id) {
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM pcdata WHERE pcID = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String line = resultSet.getInt("pcID") + " " + resultSet.getString("Name") + " " +
                        resultSet.getString("Core") + " " + resultSet.getString("Ram") +
                        " " + resultSet.getString("Lcd") + " " + resultSet.getString("Disk") +
                        " " + resultSet.getString("LabName");
                return line;
            } else {
                return "No PC Found";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
