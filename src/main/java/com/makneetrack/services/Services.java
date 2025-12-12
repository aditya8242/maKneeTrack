package com.makneetrack.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.makneetrack.database.Database;

public class Services
{
	Database dobj = new Database();

    public Services() 
	{
		dobj.CreateDB();
		dobj.CreateTable();
    }

	public void AddExpense(String dt, String category, int amount)
	{
		try
		{
			PreparedStatement ps;
			ps = dobj.getConnection().prepareStatement("insert into expenses (datetime, category, amount) values (?, ?, ?)");
			ps.setString(1, dt);
			ps.setString(2, category);
			ps.setInt(3, amount);

			ps.executeUpdate();
		}
		catch(SQLException exception)
		{
			System.out.println(exception);
		}
	}

	public void ListExpense()
	{
		try
		{
			ResultSet rs = dobj.getStatement().executeQuery("select * from expenses");	

			while(rs.next())
			{
				System.out.printf("ID: %-5d\tTime/Date: %-10s\tCategory: %-10s\tAmount: %-10d\n",rs.getInt("id"), rs.getString("datetime"), rs.getString("category"), rs.getInt("amount"));
				// %-5d %-20s %-15s %-10d%n
				// initial width
			}
		}
		catch(SQLException exception)
		{
			System.out.println(exception);
		}
	}

	public void DeleteExpense(int id)
	{
		try 
		{
			PreparedStatement ps;
			ps = dobj.getConnection().prepareStatement("delete from expenses where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} 
		catch(SQLException exception)
		{
			System.out.println(exception);
		}
	}

	public boolean isEmpty()
	{
		try
		{
			ResultSet rs = dobj.getStatement().executeQuery("select count(*) from expenses");

			if(rs.next())
			{
				int count = rs.getInt(1); // count from first row
				return count == 0; // if expression is true, table empty
			}
		}
		catch (SQLException exception)
		{
			System.out.println(exception);
		}
		return false;
	}

	public void closeDatabase()
	{
		dobj.closeDB();
	}
}