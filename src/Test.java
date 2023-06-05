import java.util.ArrayList;
import java.util.Random;

public class Test {

	public static void main(String[] args) {

		// Klingonen Raumschiff
		var klingonen = new Raumschiff("IKS Hegh'ta", 100, 100, 100, 100, 2, 1);
		var ferengiSchneckensaft = new Transportgut("Ferengi Schneckensaft", 200, 0.2f, 0.2f, 0.1f);
		var batlethKlingonenSchwert = new Transportgut("Bat'leth Klingonen Schwert", 200, 0.8f, 0.2f, 0.1f);
		var borg = new Gast("Borg", 200, "irrelevant, alphanumerischer Code", "Delta-Quadranrt",
				Verpflegung.ALLES_INKLUSIVE);
		klingonen.addLadung(batlethKlingonenSchwert);
		klingonen.addLadung(ferengiSchneckensaft);
		klingonen.addLadung(borg);

		// Romulaner Raumschiff
		var romulaner = new Raumschiff("IRW Khazara", 100, 100, 100, 100, 2, 2);
		var borgSchrott = new Transportgut("Borg-Schrott", 5, 0.2f, 0.5f, 0.5f);
		var roteMaterie = new Transportgut("Rote Materie", 2, 1.0f, 1.0f, 1.0f);
		var plasmaWaffe = new Transportgut("Plasma-Waffe", 50);
		romulaner.addLadung(plasmaWaffe);
		romulaner.addLadung(borgSchrott);
		romulaner.addLadung(roteMaterie);

		// Vulkanier Raumschiff
		var vulkanier = new Raumschiff("Ni'Var", 80, 80, 100, 50, 5, 0);
		var forschungssonde = new Transportgut("Forschungssonde", 35, 100.0f, 50.0f, 25.0f);
		var photonenTorpedos = new Transportgut("Photonentorpedo", 3, 2.0f, 2.0f, 1.0f);
		var fereng = new Gast("Ferengi", 10, "Ferengi", "Ferenginar", Verpflegung.VOLLPENSION);
		vulkanier.addLadung(photonenTorpedos);
		vulkanier.addLadung(forschungssonde);
		vulkanier.addLadung(fereng);

		// Alte Aufgabe:
		// vulkanier.zustandRaufschiff();
		// vulkanier.ladungsverzeichnisAusgeben();

		// 1. Die Klingonen schießen mit dem Photonentorpedo einmal auf die Romulaner.
		klingonen.photonentorpedoSchiessen(romulaner);

		// 2. Die Romulaner schießen mit der Phaserkanone zurück.
		romulaner.phaserkanoneSchiessen(klingonen);

		// 3. Die Vulkanier senden eine Nachricht an Alle "Gewalt ist nicht logisch".
		vulkanier.nachrichtAnAlle("Gewalt ist nicht logisch");

		// 4.Die Klingonen rufen den Zustand Ihres Raumschiffes ab und geben Ihr
		// Ladungsverzeichnis aus
		klingonen.zustandRaufschiff();
		klingonen.ladungsverzeichnisAusgeben();

		// 5. Die Vulkanier sind sehr sicherheitsbewusst und setzen alle Androiden zur
		// Aufwertung ihres Schiffes ein.
		vulkanier.erstelleReperaturAuftrag(true, true, true, klingonen.getAndroidenAnzahl());

		// 6. Die Vulkanier verladen Ihre Ladung "Photonentorpedos" in die Torpedoröhren
		// Ihres Raumschiffes und räumen das Ladungsverzeichnis auf.
		vulkanier.beladeTorpedoRohr(100);
		vulkanier.ladungverzeichnisAufraeumen();

		// 7. Die Klingonen schießen mit zwei weiteren Photonentorpedo auf die
		// Romulaner.
		klingonen.photonentorpedoSchiessen(romulaner);
		klingonen.photonentorpedoSchiessen(romulaner);

		// 8. Die Klingonen, die Romulaner und die Vulkanier rufen jeweils den Zustand
		// Ihres Raumschiffes ab und geben Ihr Ladungsverzeichnis aus.
		klingonen.zustandRaufschiff();
		romulaner.zustandRaufschiff();
		vulkanier.zustandRaufschiff();

		// Geben Sie den broadcastKommunikator aus.
		logArray(Raumschiff.getLogbuchEintraege());
	}

	public static int randomPercent() {
		return new Random().nextInt(100);
	}

	public static void logArray(ArrayList<String> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.printf("[%d] %s \n", i, arr.get(i));
		}
	}
}
