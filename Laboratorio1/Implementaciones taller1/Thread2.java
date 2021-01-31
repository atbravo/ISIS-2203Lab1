import java.io.BufferedReader;
import java.io.InputStreamReader;

//Taller 1 implementacion Interface Runnable
public class Thread2 implements Runnable {
	
	private int paridad;
	private int max;
	private String name;
	
	public Thread2(String name, int paridad, int max)
	{
		this.paridad = paridad;
		this.max = max;
		this.name = name;
	}
	public void run()
	{
		try 
		{
			for(int i = 0; i < max; i++)
			{
				if(i %2 == paridad)
				{
					System.out.println(name +": "+ i);
					Thread.sleep(50);
				}
			}
		} 
		catch (Exception e) 
		{


		}
	}
	public static void main(String[] args)
	{
		int max = 0;
		try {
			System.out.println("Ingrese cota superior");
			 BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
	        max = Integer.parseInt(reader.readLine()); 
		} 
		catch (Exception e)
		{
			System.out.println("Hubo un error leyendo su entrada, verifique que sea un numero");
		}
		
		Thread pares = new Thread(new Thread2("pares",0,max));
		Thread impares = new Thread(new Thread2("impares",1,max));
		pares.start();
		impares.start();
	}

}
