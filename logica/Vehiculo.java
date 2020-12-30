package logica;

public class Vehiculo {
	
	private String codigo;
	private String marca;
	private double precio;
	
	public Vehiculo(){}
	
	public Vehiculo(String codigo, String marca, double precio) {
		this.codigo = codigo;
		this.marca = marca;
		this.precio = precio;
	}
	
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vehiculo: codigo=" + codigo + ", marca=" + marca + ", precio=" + precio;
	}
	
	

}
