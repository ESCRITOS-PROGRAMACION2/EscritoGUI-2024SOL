package logica;

public class Auto extends Vehiculo {
    private int cilindrada;

    public Auto(String matricula, String marca, double precio, int cilindrada) {
        super(matricula, marca, precio); 
        this.cilindrada = cilindrada;
    }

    
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    
    public String toString() {
        return super.toString() + "\n Cilindrada: "+ cilindrada + "\n";
    }
    
 // Método promocion: aplica un descuento del 20% si la cilindrada es menor a 10 sino es 0
    public double promocion() {
    	 double descuento=0;
        if (cilindrada < 10) {
            descuento = getPrecio() * 0.20;
            
        } 
            return descuento; 
        
    }
}

