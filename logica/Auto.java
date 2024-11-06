package logica;

public class Auto extends Vehiculo {
    private int cilindrada;

    public Auto(String matricula, String marca, double precio, int cilindrada) {
        super(matricula, marca, precio); // Llama al constructor de Vehiculo
        this.cilindrada = cilindrada;
    }

    
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    
    public String toString() {
        return super.toString() +
               ", cilindrada=" + cilindrada;
    }
    
    // Método promocion: aplica un descuento del 20% si la cilindrada es menor a 10
    public void promocion() {
        double descuento=0;
        if (cilindrada < 10) {
            descuento = getPrecio() * 0.20;
            setPrecio(getPrecio() - descuento);
        }
    }
}
