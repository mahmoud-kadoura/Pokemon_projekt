package class_of_Pokemon;

public class TrainerPokemon extends Pokemon {

	
private String trainerName;
	
    public TrainerPokemon(String name, String typ, double maxHp,
                          int ang, int vert, int spd, String trainerName,
                          Attacke[] attacken) {
        super(name, typ, maxHp, ang, vert, spd, attacken);
        this.trainerName = trainerName;
    }
    
    @Override 
    public void greifAn(Pokemon gegner, int index) {
    	
        Attacke a = this.getAttacke(index);
        int s = a.getSchaden() * getAngriff() / gegner.getVerteidigung();
        s = (int) (s * 1.15);
        gegner.nimmSchaden(s);
        System.out.printf("%s  %s setzt %s ein! -> %d Schaden%n", trainerName, this.getName(), a.getName(), s);
        if (a.getStatusEffekt() != null)
            System.out.printf("%s leidet unter: %s!%n", gegner.getName(), a.getStatusEffekt());
    }
    
    public void zeigeTrainerInfo() {
    	System.out.println("Trainer ist: " + this.trainerName);
    }
}
