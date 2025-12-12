package com.makneetrack.database;

import java.sql.*;

public class Database
{
	public Connection connection;
	public Statement statement;

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
}