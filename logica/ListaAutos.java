package logica;

import java.util.ArrayList;

public class ListaAutos {
    
    private ArrayList<Auto> autos;

    public ListaAutos() {
        autos = new ArrayList<>();
    }

    public void agregar(Auto a) {
        autos.add(a);
    }

    
    public void borrar(Auto a) {
        autos.remove(a);
    }

    public Auto obtenerXMatricula(String matricula) {
        for (Auto auto : autos) {
            if (auto.getMatricula().equals(matricula)) {
                return auto;
            }
        }
        return null; 
    }

    
    public boolean estaAuto(String matricula) {
        for (Auto auto : autos) {
            if (auto.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    
  //toString()
    public String listarAutos() {
    	String lista="Matrícula\tMarca \tPrecio \tCilindrada\n";
        if (autos.isEmpty()) {
            return "No hay autos en la lista.";
        } else {
            for (int i = 0; i < autos.size(); i++) {
                lista += autos.get(i).toString();
            }
            return lista;
        }
    }
}


