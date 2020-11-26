package mastermind;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console
{
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public void out (String salida){
		System.out.print(salida);
	}	
	
	public String in (String mensaje){
		String input = null;
		System.out.print(mensaje);
	
		try 
		{
			input = reader.readLine();
		}
		catch (Exception e) 
		{		
			return "";		
		}
		return input;
	}

}