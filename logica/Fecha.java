package logica;


public class Fecha	{
	
	private int dia;
	private int mes;
	private int anio;
	
	public Fecha ()	{
		
	}

	public Fecha (int d, int m, int a)	{
		
		this.dia = d;
		this.mes = m;
		this.anio = a;
	}
	
	
	
	public void setDia (int d)	{
		
		dia = d;
	}
	public void setMes (int m)	{
		
		mes = m;
	}
	public void setAnio (int a)	{
		
		anio = a;
	}
	
		
	public int getDia ()	{
		
		return dia;
	}
	public int getMes ()	{
		
		return mes;
	}
	public int getAnio ()	{
		
		return anio;
	}
	
	@Override
	public String toString (){
				
		return dia+ "/" + mes+ "/" + anio;
	}
	
	
}
