import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.IOException;

public class FooBarBaz
{
	public static void console()
	{
		System.out.println("FooBarBaz");
		System.out.println("Type 999 to exit.");
		
		Scanner s = new Scanner(System.in);
		long MAX = Long.MAX_VALUE;
		
		while(true) 
		{
			System.out.println("Input a number: ");
			long input = s.nextLong();
		
			if(input < MAX && input > 1)
			{
				if(input == 999) { break;} 
				else 
				{ 
					for(long i = 0; i <= input; i++)
					{
						String out = "";
	
						if(i == 0) { out = "" + i;}
						else
						{
							if(i % 3 == 0) { out += "Foo";}
			
							if(i % 5 == 0) { out += "Bar";}
			
							if(i % 7 == 0) { out += "Baz";}
			
							if(out == "") { out = "" + i; }
						}
			
						System.out.println(out);
			
					}
		
				}	
			}
			else { System.out.println("Unexpected input.");}
		}
	}
	
	public static void batch()
	{
		String OUT_PATH = "C:/Users/augus/github-repositories/fbb-5930-f20-ageierma/src/resources/fbb-actual-output.txt";
		String IN_PATH = "C:/Users/augus/github-repositories/fbb-5930-f20-ageierma/src/resources/fbb-input.txt";
		
		
		//code snippet from 
		//https://www.dev2qa.com/how-to-write-console-output-to-text-file-in-java/
		try
		{
			// Save original out stream.
			PrintStream originalOut = System.out;
			// Create a new file output stream.
			PrintStream fileOut = new PrintStream(OUT_PATH);
			// Redirect standard out to file.
			System.setOut(fileOut);
		
			long MAX = Integer.MAX_VALUE;
		
			File f = new File(IN_PATH);
			Scanner s = new Scanner(f);
			
			while(s.hasNextLine())
			{
				String input = s.nextLine();
		
				while(true) 
				{
	
					if("stop".equalsIgnoreCase(input)) { break; }
			
					try
					{
						int num = Integer.parseInt(input);
					
						if(num > 1 && num < MAX)
						{
							
								String out = num + "=";
	
								if(num == 0) { out = num + "=" + num;}
								else
								{
									if(num % 3 == 0) 
									{ 
										out += "Foo";
										if(num % 5 == 0) 
										{
											out += "Bar";
											if(num % 7 == 0)
											{ 
												out+="Baz";
											}
										}
									}
									else { out = num + "=" + num;}
									
								}
			
								fileOut.println(out);
						}
						else 
						{ 
							fileOut.println(input + "=invalid");
						}
						break;
					}
					catch(NumberFormatException e)
					{
						fileOut.println(input += "=invalid");
					}
					break;
				}
				System.setOut(originalOut);
			}
			s.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		
			if(args != null && args.length > 0)
			{
				if(args[0].equals("console"))
				{
					FooBarBaz.console();
				}
				else if(args[0].equals("batch"))
				{
					FooBarBaz.batch();
				}
				else
				{
					System.out.println("No args specified. Switching to console.");
					FooBarBaz.console();
				}
		
			}
			else { System.out.println("Invalid args."); }
	}
		
}