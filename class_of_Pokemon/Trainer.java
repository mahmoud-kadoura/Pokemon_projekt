package class_of_Pokemon;

public class Trainer {

	private String   name;
    private Pokemon[] team;

    public Trainer(String n, Pokemon[] t) { name=n; team=t; }

    public String getName() { return this.name; }

    public void setPokemon(int i, Pokemon p) {
        if (i >= 0 && i < this.team.length) this.team[i] = p;
    }

    public void zeigeTeam() {
        System.out.println("Team von " + this.name + ":");
        for (Pokemon p : this.team) { if (p != null) p.zeigeStatus(); }
    }

    public boolean allesBesiegt() {
        for (Pokemon p : this.team)
            if (p != null && !p.istBesiegt()) return false;
        return true;
    }

    public Pokemon naechstesAktiv() {
        for (Pokemon p : this.team)
            if (p != null && !p.istBesiegt()) return p;
        return null;
    }
}
