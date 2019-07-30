package batalla;

public class Mago extends Personaje{

    public Mago() {
        super();
    }

    public Mago(String nombre, int salud, int ataque, int defensa) {
        super(nombre, salud, ataque, defensa);
    }

    @Override
    public void atacar(Personaje a) {
        System.out.println(nombre + " ataca!");
        if (xp == 30){
            ataqueEspecial(a);
        }
        int critico = dadin.tirarDado();
        int daño;
        if (critico == 6) {
            System.out.println("Daño crítico!");
            daño = (ataque * critico) + ataque;
        } else {
            daño = ataque * dadin.tirarDado();
        }
        a.recibirDaño(daño);
        xp += 10;
    }
    
    @Override
    public String toString() {
        return "Mago{" + super.toString() + '}';
    }
    
}
