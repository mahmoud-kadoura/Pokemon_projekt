package class_of_Pokemon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("================================");
		System.out.println("      POKEMON EDITION JAVA      ");
		System.out.println("================================");
		System.out.println();
		System.out.println("Hallo! Willkommen in der Welt der Pokemon!");
		System.out.println("Mein Name ist Professor Eich.");
		System.out.println("Diese Welt wird von Wesen bewohnt, die Pokemon genannt werden.");
		
		Scanner scanner = new Scanner(System.in);

        // Wild-Pokemon Auswahl (zufaellig):
        WildPokemon[] wildPool = {
            new WildPokemon("Rattikarl", "Normal",  50,  5, 3, 12, 65),
            new WildPokemon("Taubsi",    "Flug",    45,  4, 3, 13, 70),
            new WildPokemon("Hornliu",   "Kaefer",  40,  3, 4, 10, 80)
        };

        int wildIndex = (int)(Math.random() * wildPool.length);
        WildPokemon wildGegner = wildPool[wildIndex];

        //System.out.println("\nEin wildes " + wildGegner.getName() + " erscheint!");
       // wildGegner.zeigeStatus();


        // SCHRITT 3: Starterauswahl und Trainer aufbauen
        // ------------------------------------
        System.out.print("\nWie heisst dein Trainer? ");
        String trainerName = scanner.nextLine();
        
        System.out.println("Du hast Professor : " + trainerName);

        int wahl = 0;
        do {
            System.out.println("\nWaehle deinen Starter:");
            System.out.println("1 - Glumanda (Feuer)");
            System.out.println("2 - Schiggy  (Wasser)");
            System.out.println("3 - Bisasam  (Pflanze)");
            System.out.print("\nGib deine Wahl ein: ");
            wahl = scanner.nextInt();
        } while (wahl < 1 || wahl > 3);
        
        
        // Dein Code: TrainerPokemon erstellen, Team aufbauen
        // Rival-Trainer erstellen mit Konter-Team
        Attacke glut          = new Attacke("Glut",           40, "Verbrennung");
        Attacke kratzer       = new Attacke("Kratzer",        35, null);
        Attacke wasserpistole = new Attacke("Wasserpistole",  40, null);
        Attacke bodycheck     = new Attacke("Bodycheck",      35, null);
        Attacke rankenhieb    = new Attacke("Rankenhieb",     40, null);
        Attacke schlitzer     = new Attacke("Schlitzer",      35, null);
        
        
        TrainerPokemon[] spielerTeams;
        TrainerPokemon[] rivalTeams;
        
        
        if (wahl == 1) {
        	spielerTeams = new TrainerPokemon[] {
        				   new TrainerPokemon ("Glumanda", "Feuer", 100, 10, 5, 8, trainerName,
        				   new Attacke[] {glut, kratzer}),
        				   new TrainerPokemon ("Schiggy", "Wasser", 100, 9,6,10,trainerName,
        				   new Attacke[] {wasserpistole, bodycheck}),
        				   new TrainerPokemon("Bisasam", "Pflanze",100, 8,7,7,trainerName,
        				   new Attacke[]{rankenhieb,schlitzer})		
        				};
        	 rivalTeams =  new TrainerPokemon[]{
                     	   new TrainerPokemon("Schiggy", "Wasser", 100, 9, 6, 10,"Ash",
                    	   new Attacke[]{wasserpistole,bodycheck}),
                     	   new TrainerPokemon("Bisasam", "Pflanze",100, 8, 7, 7,"Ash",
                     	   new Attacke[]{rankenhieb,schlitzer}),
                     	   new TrainerPokemon("Glumanda","Feuer",  100, 10, 5, 8,"Ash",
                     	   new Attacke[]{glut,kratzer})
        	 			};
        }else if (wahl == 2) {
           spielerTeams =  new TrainerPokemon[]{
                    	   new TrainerPokemon("Schiggy", "Wasser", 100,9,6,10,trainerName,
                    	   new Attacke[]{wasserpistole,bodycheck}),
                    	   new TrainerPokemon("Bisasam", "Pflanze",100,8,7,7,trainerName,
                    	   new Attacke[]{rankenhieb,schlitzer}),
                    	   new TrainerPokemon("Glumanda","Feuer",  100,10,5,8,trainerName,
                    	   new Attacke[]{glut,kratzer})
                };
            rivalTeams =   new TrainerPokemon[]{
                    	   new TrainerPokemon("Bisasam", "Pflanze",100,8,7,7,"Gary",
                    	   new Attacke[]{rankenhieb,schlitzer}),
                    	   new TrainerPokemon("Glumanda","Feuer",  100,10,5,8,"Gary",
                    	   new Attacke[]{glut,kratzer}),
                    	   new TrainerPokemon("Schiggy", "Wasser", 100,9,6,10,"Gary",
                    	   new Attacke[]{wasserpistole,bodycheck})
                			};
        }else {
        	spielerTeams =	new TrainerPokemon[] {
        					new TrainerPokemon("Bisasam", "Pflanze",100,8,7,7,"Gary",
        					new Attacke[]{rankenhieb,schlitzer}),
        					new TrainerPokemon("Glumanda","Feuer",  100,10,5,8,"Gary",
        					new Attacke[]{glut,kratzer}),
        					new TrainerPokemon("Schiggy", "Wasser", 100,9,6,10,"Gary",
        					new Attacke[]{wasserpistole,bodycheck})
        				};
        	rivalTeams = 	new TrainerPokemon[] {
				   			new TrainerPokemon ("Glumanda", "Feuer", 100, 10, 5, 8, trainerName,
				   			new Attacke[] {glut, kratzer}),
				   			new TrainerPokemon ("Schiggy", "Wasser", 100, 9,6,10,trainerName,
				   			new Attacke[] {wasserpistole, bodycheck}),
				   			new TrainerPokemon("Bisasam", "Pflanze",100, 8,7,7,trainerName,
				   			new Attacke[]{rankenhieb,schlitzer})		
					};
        					}
        
        	
        Trainer spieler = new Trainer(trainerName, spielerTeams);
        Trainer rival   = new Trainer("Gary", rivalTeams);
        
        // Wild-Kampf
        System.out.println();
        System.out.println("Ein wildes " + wildGegner.getName() + " erscheint!");
        wildGegner.zeigeStatus();
        
        Pokemon starter = spieler.naechstesAktiv();
        System.out.println("Los! " + starter.getName() + "!");
        
        
        boolean wildGewonnen = false;
        while (!starter.istBesiegt() && !wildGegner.istBesiegt()) {
            starter.zeigeStatus(); wildGegner.zeigeStatus();
            System.out.println("\n1-" + starter.getAttackenAnzahl() + " Attacke | 5 - Fliehen");
            for (int i = 0; i < starter.getAttackenAnzahl(); i++)
                System.out.println((i+1) + " - " + starter.getAttacke(i).getName());

            int auswahl;
            do { System.out.print("Wahl: "); auswahl = scanner.nextInt(); }
            while ((auswahl < 1 || auswahl > starter.getAttackenAnzahl()) && auswahl != 5);

            if (auswahl == 5) { System.out.println("Du bist geflohen!"); break; }

            starter.greifAn(wildGegner, auswahl - 1);
            if (wildGegner.istBesiegt()) { wildGewonnen = true; break; }
            wildGegner.greifAn(starter, 0);
            if (starter.istBesiegt()) System.out.println(starter.getName() + " wurde besiegt!");
        }

        System.out.println(wildGewonnen ? "\nWild-Kampf gewonnen!" : "\nWild-Kampf beendet.");
        System.out.printf("%s hat noch %.0f HP fuer den Rivalen-Kampf.%n",
                starter.getName(), starter.getHp());

        // Rivalen-Kampf
        System.out.println("\n" + "=".repeat(40));
        System.out.println("RIVALEN-KAMPF: " + spieler.getName() + " vs. " + rival.getName());
        System.out.println("=".repeat(40));

        int runde = 0;
        while (!spieler.allesBesiegt() && !rival.allesBesiegt()) {
            runde++;
            Pokemon aktiv  = spieler.naechstesAktiv();
            Pokemon gegner = rival.naechstesAktiv();

            System.out.println("\n--- Runde " + runde + " ---");
            aktiv.zeigeStatus(); gegner.zeigeStatus();

            System.out.println("\nWelche Attacke?");
            for (int i = 0; i < aktiv.getAttackenAnzahl(); i++)
                System.out.println((i+1) + " - " + aktiv.getAttacke(i).getName());

            int auswahl;
            do { System.out.print("Wahl: "); auswahl = scanner.nextInt(); }
            while (auswahl < 1 || auswahl > aktiv.getAttackenAnzahl());

            aktiv.greifAn(gegner, auswahl - 1);
            if (gegner.istBesiegt()) {
            	System.out.println("Du hast " + gegner.getName() + " besiegt!");
            	System.out.println("Gary: Das gibt's doch nicht!");
            	System.out.println("Ich muss wohl noch mehr trainieren...");
            	continue; }
            	gegner.greifAn(aktiv, 0);
            	
            if (aktiv.istBesiegt()) 
            	System.out.println();
            	System.out.println(aktiv.getName() + " wurde besiegt!");
            	System.out.println(trainerName + " hat kein kampffähiges Pokemon mehr!");
            	System.out.println("Du hast gegen " + gegner.getName() +" verloren...");
            	
        }

        System.out.println("\n" + "=".repeat(40));
        System.out.println(spieler.allesBesiegt()
                ? rival.getName() + " gewinnt nach " + runde + " Runde(n)!"
                : spieler.getName() + " gewinnt nach " + runde + " Runde(n)!");

        scanner.close();
        
	}
}
