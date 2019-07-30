/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla;

/**
 *
 * @author nico
 */
public class Personaje {
    
    final Dado dadin = new Dado(6);
    protected String nombre;
    protected int salud;
    protected int ataque;
    protected int defensa;
    protected int xp;
    
    
    public Personaje(){
        
        nombre = "";
        salud = 1800;
        ataque = 100;
        defensa = 100;
        xp = 0;
    }

    public Personaje(String nombre, int salud, int ataque, int defensa) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
        xp = 0;
        
        if (salud > 2000){
            salud = 2000;
        }
        if (ataque > 2000){
            ataque = 2000;
        }
        if (defensa > 2000){
            defensa = 2000;
        }
        
        
        int valor = salud +ataque + defensa;
        if (valor > 2000){
            int prom = valor - 2000;
            prom = (int) Math.floor(prom /3);
            this.ataque = ataque - prom;
            this.defensa = defensa - prom;
            this.salud = salud - prom;
        }
        
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getSalud() {
        return salud;
    }

    public int getXp() {
        return xp;
    }
    
    public boolean estaSaludable() {
        
        return salud > 0;
    }
    
    public void atacar(Personaje h) {
            System.out.println(nombre + " ataca!");
            int daño = ataque * dadin.tirarDado();
            System.out.println(daño);
            h.recibirDaño(daño);
            xp += 10;
	}
    
    public void ataqueEspecial(Personaje A){
        System.out.println("El " + nombre + " ah desbloqueado LA CHANCLA!");
        salud += 150;
        int daño = (ataque + 25) * dadin.tirarDado();
        A.recibirDaño(daño);
        xp = 0;
    }
    
    public void recibirDaño(int daño) {
		int golpe = daño - defensa * dadin.tirarDado();
		salud -= golpe;
		System.out.println(nombre + " recibe " + golpe + " de daño.");
    
    }

    @Override
    public String toString() {
        return "Personaje{" + "dadin=" + dadin + ", nombre=" + nombre + ", salud=" + salud + ", ataque=" + ataque + ", defensa=" + defensa + ", xp=" + xp + '}';
    }
    
    
}
