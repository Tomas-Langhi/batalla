package batalla;

public class Dado {

    private int cantidadDeLados;
    
    public Dado(){
        cantidadDeLados = 15;
    }
    
    public Dado(int cantidadDeLados) {
        this.cantidadDeLados = cantidadDeLados;
    }
    
    public void setDado(int cantidadDeLados) {
        this.cantidadDeLados = cantidadDeLados;
    }

    public int tirarDado() {
        return (int) Math.floor(Math.random() * cantidadDeLados) + 1;
    }

    @Override
    public String toString() {
        return "Dado{" + "cantidadDeLados= " + cantidadDeLados + '}';
    }

    
    
}
