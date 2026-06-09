package class_of_Pokemon;

public class Attacke {

	
	private String name;
    private int    schaden;
    private String statusEffekt;

    public Attacke(String name, int schaden, String statusEffekt) {
        this.name = name; this.schaden = schaden; this.statusEffekt = statusEffekt;
    }

    public String getName()         { return this.name; }
    public int    getSchaden()      { return this.schaden; }
    public String getStatusEffekt() { return this.statusEffekt; }
    
    
}
