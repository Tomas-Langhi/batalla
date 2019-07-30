package batalla;

import java.util.Scanner;

public class Pelear{

    public Pelear(){
        Dado d15 = new Dado();
        Personaje orc = new Orco();
        Personaje cab = new Caballero();
        Personaje mag = new Mago();
    }
    
    public Pelear(Dado d15, Personaje orc, Personaje cab, Personaje mag){
        
    }
    
    public void Batallar(Dado d15, Personaje orc, Personaje cab, Personaje mag){
        System.out.println("Esta sera una batalla legendaria");
        System.out.println("Combaten " + orc.getNombre() + ", " 
                + cab.getNombre() + " y " + mag.getNombre());
        
        int ataques = 0;
        int muertes = 0;
        while (muertes < 2) {
            int tirada = d15.tirarDado();
            System.out.println("Dado = " + tirada);
            
            //ataca el caballero
            if (tirada > 10) {
                if (cab.estaSaludable()){
                    Personaje a;
                    int t = (int) (Math.random() * 10);
                    if (t >= 5){a = orc;}else{a = mag;}
                    //evito que ataque a un personaje muerto
                    if (a.estaSaludable() == false){a = orc;}
                    if (a.estaSaludable() == false){a = mag;}
                    cab.atacar(a);
                    System.out.println("Salud restante de " 
                            + a.getNombre() + " = " + a.getSalud());
                    if (a.estaSaludable() == false){muertes++;}
                }
            }
            
            //ataca el mago
            if (tirada <= 10 && tirada > 5) {
                if (mag.estaSaludable()){
                    Personaje a;
                    int t = (int) (Math.random() * 10);
                    if (t >= 5){a = orc;}else{a = cab;}
                    //evito que ataque a un personaje muerto
                    if (a.estaSaludable() == false){a = orc;}
                    if (a.estaSaludable() == false){a = cab;}
                    mag.atacar(a);
                    System.out.println("Salud restante de " 
                            + a.getNombre() + " = " + a.getSalud());
                    if (a.estaSaludable() == false){muertes++;}
                }
            }
            
            //el orco ataca
            if (tirada <= 5) {
                if (orc.estaSaludable()){
                    Personaje a;
                    int t = (int) (Math.random() * 10);
                    if (t >= 5){a = mag;}else{a = cab;}
                    //evito que ataque a un personaje muerto
                    if (a.estaSaludable() == false){a = mag;}
                    if (a.estaSaludable() == false){a = cab;}
                    orc.atacar(a);
                    System.out.println("Salud restante de " 
                            + a.getNombre() + " = " + a.getSalud());
                    if (a.estaSaludable() == false){muertes++;}
                }
                
            }
            ataques++;
            
            if (ataques == 3){
                System.out.println("");
                System.out.println("Precione enter para continuar");
                Scanner scn = new Scanner(System.in);
                scn.nextLine();
                ataques = 0;
            }
        }
    
        System.out.println("-----------------------------------------------"
            + "------------------------------");
        
        if (!orc.estaSaludable()) {
            System.out.println("El orco ha perdido!");
            System.out.println(orc);
        } else{ System.out.println("El orco a ganado");}
        
        System.out.println("-----------------------------------------------"
            + "------------------------------");
        
        if (!cab.estaSaludable()){
            System.out.println("El caballero ha perdido!");
            System.out.println(cab);
        } else{ System.out.println("El caballero a ganado");}
        
        System.out.println("-----------------------------------------------"
            + "------------------------------");
        
        if (!mag.estaSaludable()){
            System.out.println("El mago a perdido");
            System.out.println(mag);
        } else{ System.out.println("El mago a ganado");}
        
    }//funcion
    
}//toda la clase
