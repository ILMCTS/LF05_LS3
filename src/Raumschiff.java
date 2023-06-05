import java.util.ArrayList;
import java.util.Random;

/**
 * Stellt das Raumschiff dar
 * 
 * @author leander.scherwinsky
 *
 */
public class Raumschiff {
	private String schiffsname;
	private int energieversorgungInProzent;
	private int schutzschildeInProzent;
	private int lebenserhaltungssystemeInProzent;
	private int huelleInProzent;
	private int androidenAnzahl;
	private int photonentorpedoAnzahl;
	private ArrayList<Ladung> ladungsverzeichnis;

	private static ArrayList<String> broadcastKommunikator = new ArrayList<String>();

	/**
	 * Parameterloser Konstruktor
	 */
	public Raumschiff() {

	}

	/**
	 * Voll-Parametrisierter Konstruktor
	 * 
	 * @param name                    Raumschiffname
	 * @param energieversorgung       Energieversorgung in %
	 * @param schutzschilde           Schutzschule in %
	 * @param lebenserhaltungssysteme Lebenserhaltung in %
	 * @param huelle                  Hülle in %
	 * @param reperaturandroiden      Reperatur Androiden Anzahl
	 * @param photonentorpedos        Photonen Torpedo Anzahl
	 */
	public Raumschiff(String name, int energieversorgung, int schutzschilde, int lebenserhaltungssysteme, int huelle,
			int reperaturandroiden, int photonentorpedos) {
		super();
		this.schiffsname = name;
		this.energieversorgungInProzent = energieversorgung;
		this.schutzschildeInProzent = schutzschilde;
		this.lebenserhaltungssystemeInProzent = lebenserhaltungssysteme;
		this.huelleInProzent = huelle;
		this.androidenAnzahl = reperaturandroiden;
		this.photonentorpedoAnzahl = photonentorpedos;
		this.ladungsverzeichnis = new ArrayList<Ladung>();
	}

	/**
	 * Fügt eine Ladung hinzu
	 * 
	 * @param neueLadung Ladungs Objekt
	 */
	public void addLadung(Ladung neueLadung) {
		this.ladungsverzeichnis.add(neueLadung);
	}

	/**
	 * Schießt einen Photonen Torpedo auf ein Raumschiff
	 * 
	 * @param r Das Ziel Raumschiff
	 */
	public void photonentorpedoSchiessen(Raumschiff r) {
		if (this.photonentorpedoAnzahl <= 0) {
			this.nachrichtAnAlle("-=*Click*=-");
			return;
		}

		this.photonentorpedoAnzahl--;
		this.nachrichtAnAlle("Photonentorpedo abgeschossen");
		this.treffer(r);
	}

	/**
	 * Schießt die Phaserkanone auf ein Raumschiff
	 * 
	 * @param r Das Ziel Raumschiff
	 */
	public void phaserkanoneSchiessen(Raumschiff r) {
		if (this.energieversorgungInProzent < 50) {
			this.nachrichtAnAlle("-=*Click*=-");
			return;
		}

		r.setEnergieversorgungInProzent(r.energieversorgungInProzent - 50);
		this.nachrichtAnAlle("Phaserkanone abgeschossen");
		this.treffer(r);

	}

	/**
	 * Registriest einen Treffer (Schaden)
	 * 
	 * @param r Das Raumschiff, das getroffen wurde
	 */
	private void treffer(Raumschiff r) {
		System.out.printf("[%s] wurde getroffen!\n", r.schiffsname);

		// Schiff Schaden hinzufügen
		r.setSchutzschildeInProzent(r.schutzschildeInProzent - 50);
		if (r.schutzschildeInProzent <= 0) {

			r.setEnergieversorgungInProzent(r.energieversorgungInProzent - 50);
			r.setHuelleInProzent(r.huelleInProzent - 50);

			if (r.huelleInProzent <= 0) {
				r.setLebenserhaltungssystemeInProzent(0);
				r.nachrichtAnAlle(
						String.format("Die Lebenserhaltungssysteme der %s wurden vernichtet\n", r.schiffsname));
			}
		}
	}

	/**
	 * Sendet eine Nachricht an alle
	 * 
	 * @param message Die Nachricht
	 */
	public void nachrichtAnAlle(String message) {
		Raumschiff.broadcastKommunikator.add(message);
	}

	/**
	 * Ruft den Zustand vom Raumschiff ab (in der Konsole)
	 */
	public void zustandRaufschiff() {
		System.out.printf("Schiff Name = %s \n", this.schiffsname);
		System.out.printf("Energieversorgung (Prozent) = %s \n", this.energieversorgungInProzent);
		System.out.printf("Schutzschilde (Prozent) = %s \n", this.schutzschildeInProzent);
		System.out.printf("Lebenserhaltungssysteme (Prozent) = %s \n", this.lebenserhaltungssystemeInProzent);
		System.out.printf("Hülle (Prozent) = %s \n", this.huelleInProzent);
		System.out.printf("Androiden (Anzahl) = %s \n", this.androidenAnzahl);
		System.out.printf("Photonentorpedos (Anzahl) = %s \n\n", this.photonentorpedoAnzahl);
	}

	/**
	 * Ruft alle geladenen Ladungen ab (in der Konsole)
	 */
	public void ladungsverzeichnisAusgeben() {
		for (Ladung e : this.ladungsverzeichnis) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Leert das Ladungsverzeichnis auf (entfernt alle Ladungen, wo die Menge <= 0
	 * ist)
	 */
	public void ladungverzeichnisAufraeumen() {
		ArrayList<Ladung> tempLager = new ArrayList<Ladung>();

		for (Ladung e : this.ladungsverzeichnis) {
			if (0 < e.getMenge()) {
				tempLager.add(e);
			}
		}

		this.ladungsverzeichnis = tempLager;
	}

	/**
	 * Gibt die Logbucheinträge zurück
	 * 
	 * @return Alle Logbucheinträge
	 */
	public static ArrayList<String> getLogbuchEintraege() {
		return Raumschiff.broadcastKommunikator;
	}

	/**
	 * Belädt das Torpedo Rohr
	 * 
	 * @param anzahlTorpedos Die Anzahl an Torpedos, die geladen werden sollen
	 */
	public void beladeTorpedoRohr(int anzahlTorpedos) {
		Ladung torpedo = null;
		for (Ladung e : this.ladungsverzeichnis) {
			if (e.getBezeichnung() == "Photonentorpedo") {
				torpedo = e;
				break;
			}
		}

		if (torpedo == null || torpedo.getMenge() <= 0) {
			System.out.print("Keine Photonentorpedos gefunden!\n");
			this.nachrichtAnAlle("-=*Click*=-");
			return;
		}

		int torpedoAnzahlNutzbar = anzahlTorpedos;
		if (torpedo.getMenge() < anzahlTorpedos) {
			torpedoAnzahlNutzbar = torpedo.getMenge();
		}

		// Torpedo dem Schiff hinzufügen und der Ladung entfernen
		this.photonentorpedoAnzahl += torpedoAnzahlNutzbar;
		torpedo.setMenge(torpedo.getMenge() - torpedoAnzahlNutzbar);
		System.out.printf("[%d] Photonentorpedo(s) eingesetzt\n", torpedoAnzahlNutzbar);
	}

	/**
	 * Erstellt einen Reperatur Auftrag und führt diesen sofort durch
	 * 
	 * @param schutzschilde     Ob die Schutzschilde repariert werden sollen
	 * @param huelle            Ob die Hülle repariert werden soll
	 * @param energieversorgung Ob die Energieversorgung repariert werden soll
	 * @param anzahlAndroiden   Wie viele Androiden am Auftrag arbeiten sollen
	 */
	public void erstelleReperaturAuftrag(boolean schutzschilde, boolean huelle, boolean energieversorgung,
			int anzahlAndroiden) {
		int rdn = new Random().nextInt(0, 100);
		int androiden = anzahlAndroiden;
		if (this.androidenAnzahl < anzahlAndroiden) {
			androiden = this.androidenAnzahl;
		}

		int trueWerte = 0;
		if (schutzschilde) {
			trueWerte++;
		}

		if (huelle) {
			trueWerte++;
		}

		if (energieversorgung) {
			trueWerte++;
		}

		// Berechnung
		int repariert = rdn * androiden / trueWerte;

		// Setzen der Werte - Prüfung ob negativ?
		if (schutzschilde) {
			this.setSchutzschildeInProzent(this.schutzschildeInProzent + repariert);
		}

		if (huelle) {
			this.setHuelleInProzent(this.huelleInProzent + repariert);
		}

		if (energieversorgung) {
			this.setEnergieversorgungInProzent(this.energieversorgungInProzent + repariert);
		}
	}

	public String getSchiffsname() {
		return schiffsname;
	}

	public void setSchiffsname(String name) {
		this.schiffsname = name;
	}

	public int getEnergieversorgungInProzent() {
		return energieversorgungInProzent;
	}

	public void setEnergieversorgungInProzent(int energieversorgungInProzent) {
		if (energieversorgungInProzent <= 0) {
			energieversorgungInProzent = 0;
		} else if (100 < energieversorgungInProzent) {
			energieversorgungInProzent = 100;
		}

		this.energieversorgungInProzent = energieversorgungInProzent;
	}

	public int getSchutzschildeInProzent() {
		return schutzschildeInProzent;
	}

	public void setSchutzschildeInProzent(int schutzschildeInProzent) {
		if (schutzschildeInProzent <= 0) {
			schutzschildeInProzent = 0;
		} else if (100 < schutzschildeInProzent) {
			schutzschildeInProzent = 100;
		}

		this.schutzschildeInProzent = schutzschildeInProzent;
	}

	public int getLebenserhaltungssystemeInProzent() {
		return lebenserhaltungssystemeInProzent;
	}

	public void setLebenserhaltungssystemeInProzent(int lebenserhaltungssystemeInProzent) {
		if (lebenserhaltungssystemeInProzent <= 0) {
			lebenserhaltungssystemeInProzent = 0;
		} else if (100 < lebenserhaltungssystemeInProzent) {
			lebenserhaltungssystemeInProzent = 100;
		}

		this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
	}

	public int getHuelleInProzent() {
		return huelleInProzent;
	}

	public void setHuelleInProzent(int huelleInProzent) {
		if (huelleInProzent <= 0) {
			huelleInProzent = 0;
		} else if (100 < huelleInProzent) {
			huelleInProzent = 100;
		}

		this.huelleInProzent = huelleInProzent;
	}

	public int getAndroidenAnzahl() {
		return androidenAnzahl;
	}

	public void setAndroidenAnzahl(int androidenAnzahl) {
		this.androidenAnzahl = androidenAnzahl;
	}

	public int getPhotonentorpedoAnzahl() {
		return photonentorpedoAnzahl;
	}

	public void setPhotonentorpedoAnzahl(int photonentorpedoAnzahl) {
		this.photonentorpedoAnzahl = photonentorpedoAnzahl;
	}

	public ArrayList<Ladung> getLadungsverzeichnis() {
		return ladungsverzeichnis;
	}

	// eigentlich nicht relevant
	public void setLadungsverzeichnis(ArrayList<Ladung> ladungsverzeichnis) {
		this.ladungsverzeichnis = ladungsverzeichnis;
	}
}
