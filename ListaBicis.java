package paraEstudiantes;

import java.util.ArrayList;

public class ListaBicis {
	
	private ArrayList<Bicicleta> lista;

	public ListaBicis() {
		lista=new ArrayList<>();
	}
	
	public void agregar(Bicicleta b) {
		lista.add(b);
	}
	
	public void borrar(Bicicleta b) {
		lista.remove(b);
	}
	
	public boolean estaBici(Bicicleta b) {
		return lista.contains(b);
	}
	
	public int cantidad() {
		return lista.size();
	}
	
	@Override
	public String toString() {
	return " "+ lista;
	}
	
	
}

