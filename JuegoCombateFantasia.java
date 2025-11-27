abstract class Personaje {
    protected String nombre;
    protected int puntosVida;
    protected int nivel;

    public Personaje(String nombre, int puntosVida, int nivel) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.nivel = nivel;
    }

    public abstract void atacar(Personaje objetivo);
    public abstract void defender();

    public boolean estaVivo() {
        return puntosVida > 0;
    }

    public void recibirDano(int dano) {
        this.puntosVida -= dano;
        if (this.puntosVida < 0) this.puntosVida = 0;
        System.out.println(this.nombre + " recibió " + dano + " de daño. Vida restante: " + this.puntosVida);
    }
    
    public String getNombre() {
        return nombre;
    }
}

class Mago extends Personaje {
    private int mana;

    public Mago(String nombre, int vida, int nivel, int mana) {
        super(nombre, vida, nivel);
        this.mana = mana;
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (!estaVivo()) {
            System.out.println(nombre + " no puede atacar porque está debilitado (muerto).");
            return;
        }
        
        if (mana >= 10) {
            mana -= 10;
            System.out.println(nombre + " lanza una bola de fuego a " + objetivo.getNombre() + " (Maná restante: " + mana + ")");
            objetivo.recibirDano(25);
        } else {
            System.out.println(nombre + " intenta lanzar un hechizo pero NO TIENE suficiente maná.");
        }
    }

    @Override
    public void defender() {
        System.out.println(nombre + " usa un escudo mágico para reducir el daño.");
    }
}

class Guerrero extends Personaje {
    public Guerrero(String nombre, int vida, int nivel) {
        super(nombre, vida, nivel);
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (!estaVivo()) {
            System.out.println(nombre + " no puede atacar porque ha caído en combate.");
            return;
        }
        
        System.out.println(nombre + " golpea brutalmente con su espada a " + objetivo.getNombre());
        objetivo.recibirDano(15);
    }

    @Override
    public void defender() {
        System.out.println(nombre + " levanta su escudo de hierro y adopta postura defensiva.");
    }
}

class Arquero extends Personaje {
    private int flechas;

    public Arquero(String nombre, int vida, int nivel, int flechas) {
        super(nombre, vida, nivel);
        this.flechas = flechas;
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (!estaVivo()) {
            System.out.println(nombre + " no puede atacar.");
            return;
        }

        if (flechas > 0) {
            flechas--;
            System.out.println(nombre + " dispara una flecha precisa a " + objetivo.getNombre() + " (Flechas restantes: " + flechas + ")");
            objetivo.recibirDano(10);
        } else {
            System.out.println(nombre + " busca una flecha en su carcaj pero está VACÍO.");
        }
    }

    @Override
    public void defender() {
        System.out.println(nombre + " se oculta entre las sombras para evadir el ataque.");
    }
}

public class JuegoCombateFantasia {
    public static void main(String[] args) {
        System.out.println("COMBATE - INICIA");

        Mago gandalf = new Mago("Gandalf", 100, 10, 25);
        Guerrero polo = new Guerrero("polo", 150, 12);
        Arquero thor = new Arquero("thor", 80, 11, 2);


        gandalf.atacar(polo);
        polo.defender();
        thor.atacar(gandalf);

        System.out.println("\nRound 2");
        gandalf.atacar(polo);
        gandalf.atacar(polo);

        System.out.println("\nround 3 ");
        thor.atacar(polo);
        thor.atacar(polo);
        System.out.println("\nRound final");

        while(thor.estaVivo()) {
            polo.atacar(thor);
        }

        thor.atacar(polo); 
    }
}


/* UML
@startuml
skinparam classAttributeIconSize 0

abstract class Personaje {
    # nombre : String
    # puntosVida : int
    # nivel : int
    + Personaje(nombre: String, vida: int, nivel: int)
    + {abstract} atacar(objetivo : Personaje) : void
    + {abstract} defender() : void
    + estaVivo() : boolean
    + recibirDano(dano : int) : void
}

class Guerrero extends Personaje {
    + Guerrero(nombre: String, vida: int, nivel: int)
    + atacar(objetivo : Personaje) : void
    + defender() : void
}

class Mago extends Personaje {
    - mana : int
    + Mago(nombre: String, vida: int, nivel: int, mana: int)
    + atacar(objetivo : Personaje) : void
    + defender() : void
    + recargarMana(cantidad : int) : void
}

class Arquero extends Personaje {
    - flechas : int
    + Arquero(nombre: String, vida: int, nivel: int, flechas: int)
    + atacar(objetivo : Personaje) : void
    + defender() : void
    + recargarFlechas(cantidad : int) : void
}

@enduml 
*/