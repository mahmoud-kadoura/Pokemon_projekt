package class_of_Pokemon;


public class Pokemon {

	
	protected String   name;
	protected String   typ;
	protected double   hp;
	protected double   maxHp;
	protected int      angriff;
	protected int      verteidigung;
	protected int      speed;
	protected Attacke[] attacken;

    public Pokemon(String name, String typ, double maxHp,
                   int angriff, int verteidigung, int speed, Attacke[] attacken) {
        this.name = name; this.typ = typ; this.maxHp = maxHp; this.hp = maxHp;
        this.angriff = angriff; this.verteidigung = verteidigung; this.speed = speed;
        this.attacken = attacken;
    }

    public String  getName()          { return this.name; }
    public String  getTyp()           { return this.typ; }
    public double  getHp()            { return this.hp; }
    public double  getMaxHp()         { return this.maxHp; }
    public int     getAngriff()       { return this.angriff; }
    public int     getVerteidigung()  { return this.verteidigung; }
    public int     getSpeed()         { return this.speed; }
    public Attacke getAttacke(int i)  { return this.attacken[i]; }
    public int     getAttackenAnzahl(){ return this.attacken.length; }
    public boolean istBesiegt()       { return this.hp <= 0; }

    public void nimmSchaden(int s) { this.hp -= s; if (this.hp < 0) this.hp = 0; }
    public void heile(int m)       { this.hp += m; if (this.hp > this.maxHp) this.hp = this.maxHp; }

    public void greifAn(Pokemon gegner, int index) {
        Attacke a = this.attacken[index];
        int s = a.getSchaden() * this.angriff / gegner.getVerteidigung();
        gegner.nimmSchaden(s);
        System.out.printf("%s setzt %s ein! -> %d Schaden%n", name, a.getName(), s);
        if (a.getStatusEffekt() != null)
            System.out.printf("%s leidet unter: %s!%n", gegner.getName(), a.getStatusEffekt());
    }

    public void zeigeStatus() {
        System.out.printf("%-12s HP: %5.1f / %.0f%n", this.name, this.hp, this.maxHp);
    }
}
