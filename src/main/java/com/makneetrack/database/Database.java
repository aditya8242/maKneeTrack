package com.makneetrack.database;

import java.sql.*;

public class Database
{
	private Connection connection;
	private Statement statement;
	
	public Connection getConnection() {
		return connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void CreateDB()
	{
		try
		{
			connection = DriverManager.getConnection("jdbc:sqlite:expenses.db");
			statement = connection.createStatement();
		}
		catch(SQLException exception)
		{
			System.out.println(exception);
		}
	}

	public void CreateTable()
	{
		try
		{
			statement.executeUpdate("create table if not exists expenses(id integer primary key, datetime text, category text, amount int)");
		}
		catch (SQLException exception)
		{
			System.out.println(exception);
		}
	}

	public void closeDB()
	{
		try 
        {
            if (statement != null)
			{
                statement.close();
            }
            if (connection != null) 
			{
                connection.close();
            }
        } 
        catch (SQLException exception)
        {
            System.out.println(exception);
        }
	}
}