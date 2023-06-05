
/**
 * Die Basis Klasse für eine Ladung
 * 
 * @author leander.scherwinsky
 *
 */
public abstract class Ladung {
	private String bezeichnung;
	private int menge;

	/**
	 * Parameterloser Konstruktor
	 */
	public Ladung() {

	}

	/**
	 * Voll-Parametrisierter Konstruktor
	 * 
	 * @param name   Bezeichnung der Ladung
	 * @param anzahl Die Anzahl der Ladung
	 */
	public Ladung(String name, int anzahl) {
		this.bezeichnung = name;
		this.menge = anzahl;
	}

	/**
	 * Gibt eine String Repräsentation des Objektes zutück
	 */
	@Override
	public abstract String toString();

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}
}
