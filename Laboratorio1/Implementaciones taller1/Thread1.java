import java.io.BufferedReader;
import java.io.InputStreamReader;

//Taller 1 implementacion extendiendo la clase Thread
public class Thread1  extends Thread
{
	private int paridad;
	private String name;
	private int tiempo;
	private int max;
	public Thread1(int paridad,String name,int tiempo,int max)
	{
		this.paridad = paridad;
		this.name = name;
		this.tiempo = tiempo;
		this.max = max;
	}
	public void run(){
		try
		{
			for(int i = 0; i < max; i++)
			{
				if(i%2 == paridad)
				{
					System.out.println(name +": " +i);
					Thread.sleep(tiempo);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
		System.out.println( name + ": Fin exitoso");
	}
	public static void main(String[] args){
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
		Thread1 pares = new Thread1(0,"pares",250,max);
		Thread1 impares = new Thread1(1,"impares",250,max);
		pares.start();
		impares.start();
	}
}
