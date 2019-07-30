package batalla;

public class Batalla {

    public static void main(String[] args) {
        
        Dado d = new Dado();

        String nombre = "Sir Lancelot";
        int salud = 1800;
        int ataque = 150;
        int defensa = 50;
        Caballero c = new Caballero(nombre, salud, ataque, defensa);
        System.out.println(c);
        System.out.println("");
        
        
        nombre = "Gul'dan";
        salud = 1800;
        ataque = 150;
        defensa = 50;

        Orco o = new Orco(nombre, salud, ataque, defensa);
        System.out.println(o);
        System.out.println("");
        
        
        Mago m = new Mago("Merlin", 1800, 150, 50);
        System.out.println(m);
        System.out.println("");
        
        Pelear pelea = new Pelear(d, o, c, m);
        pelea.Batallar(d, o, c, m);
    }

}
