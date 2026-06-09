package class_of_Pokemon;

public class WildPokemon extends Pokemon {

	
	private int catchRate;

    public WildPokemon(String name, String typ, double maxHp,
                       int ang, int vert, int spd, int catchRate) {
    	
        super(name, typ, maxHp, ang, vert, spd, new Attacke[]{
        		
            new Attacke("Tackle", 15, null) } );
        
        this.catchRate = catchRate;
    }

    public int getCatchRate() { return this.catchRate; }
    
    @Override
   	public void zeigeStatus() {
   		System.out.printf("[WILD] %s  HP: %5.1f / %.0f  | Fangrate: %d%% %n", 
   						this.getName(), this.getHp(), this.getMaxHp(), this.catchRate);
   		}
    
    @Override 
    public void greifAn(Pokemon gegner, int index) {
    	Attacke a = this.getAttacke(index);
        double faktor = 0.5 + Math.random(); 	//* 1.0
        int s = a.getSchaden() * this.getAngriff() / gegner.getVerteidigung() ;
        s = (int) (s * faktor);
        gegner.nimmSchaden(s);
        System.out.printf("%s setzt %s ein! -> %d Schaden%n", this.getName(), a.getName(), s);
        if (a.getStatusEffekt() != null)
            System.out.printf("%s leidet unter: %s!%n", gegner.getName(), a.getStatusEffekt());
    }
}
