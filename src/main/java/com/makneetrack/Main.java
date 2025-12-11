package com.makneetrack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.makneetrack.services.Services;

public class Main {
    public static void main(String[] args)
	{
		int choice = 0;
		int amount = 0, deleteID = 0;
		String dateTime = null, category = null;

		Services ssobj = new Services();

		Scanner sobj = new Scanner(System.in);

		while (true)
		{
			System.out.println("========Simple Expense Tracker========");
			System.out.println("Options:");
			System.out.println("1. Add expense\t2.List all expenses\t3.Delete expense\t4.Exit");
			System.out.print("Enter your choice: ");
			
			try
			{	
				choice = sobj.nextInt();
				sobj.nextLine();
			}
			catch(InputMismatchException exception)
			{
				System.out.println("=================================================================================");
				System.out.println("Enter a valid number input!");
				System.out.println("=================================================================================");
				sobj.nextLine();
				continue;
			}

			switch (choice)
			{
				case 1:
					System.out.println("Enter your expense:");

					System.out.print("Date/Time (DD-MM-YYYY HH:mm): ");
					dateTime = sobj.nextLine();
					
					System.out.print("Category: ");
					category = sobj.nextLine();

					System.out.print("Amount: ");
					amount = sobj.nextInt();
					
					sobj.nextLine();

					ssobj.AddExpense(dateTime, category, amount);

					System.out.println("Expense added successfully!");
					
					System.out.println();

					break;
				
				case 2:
					if(ssobj.isEmpty())
					{
						System.out.println("=================================================================================");
						System.out.println("No expenses!");
						System.out.println("=================================================================================");

						System.out.println();
					}
					else
					{
						System.out.println("=================================================================================");
						ssobj.ListExpense();
						System.out.println("=================================================================================");

						System.out.println();
					}
					break;

				case 3:
					if(ssobj.isEmpty())
					{
						System.out.println("=================================================================================");
						System.out.println("No expense to delete.");
						System.out.println("=================================================================================");
					}
					else
					{
						System.out.println("Enter expense ID:");
						deleteID = sobj.nextInt();
						ssobj.DeleteExpense(deleteID);
						System.out.println("Expense with ID " + deleteID + " deleted!");
					}

					System.out.println();
					break;

				case 4:
					System.out.println("Exiting program...Bye!");
					return;

				default:
					System.out.println("Invalid input!");
			}
		}
    }
}