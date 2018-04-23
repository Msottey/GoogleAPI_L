package com.company;

import java.sql.*;


public class SQL {

    String sqlDB = "Divvy_Rideshare";
    String sqlTable ="Divvy_Rides";
    String server = "G8Q9JQ72E"+"\\"+"\\SQLEXPRESS";
    Statement statement;
    Connection connection;
    ResultSet resultSet;
    private static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    SQL()
    {

    }

    public void sqlConnection(){



        try {
            this.setConnection(DriverManager.getConnection("jdbc:sqlserver://server:1433;DatabaseName=Divvy_Rideshare;"));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void closeSQL(){
        try
        {
            this.getConnection().close();
        }
        catch (SQLException sql)
        {

        }
    }

    public void readInputs(){
        try
        {
            this.setStatement(this.getConnection().createStatement());
            this.setResultSet(this.getStatement().executeQuery("jdbc:sqlserver://localhost:1433;" +
                    "databaseName="+this.sqlDB+";"));

        }
        catch (SQLException sql)
        {

        }

    }

    public void writeOutputs(){

        try {
            this.getStatement().executeUpdate("INSERT INTO Customers " + "VALUES (1)");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getSqlDB() {
        return sqlDB;
    }

    public void setSqlDB(String sqlDB) {
        this.sqlDB = sqlDB;
    }

    public String getSqlTable() {
        return sqlTable;
    }

    public void setSqlTable(String sqlTable) {
        this.sqlTable = sqlTable;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
