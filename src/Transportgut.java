/**
 * Stellt eine spezielle Ladung dar
 * 
 * @author leander.scherwinsky
 *
 */
public class Transportgut extends Ladung {

	private float laengeMeter;
	private float breiteMeter;
	private float hoeheMeter;

	/**
	 * Leerer Konstruktor
	 */
	public Transportgut() {
		super();
	}

	/**
	 * Parametrisierter Konstruktor
	 * 
	 * @param name   Bezeichnung des Gutes
	 * @param anzahl Anzahl des Gutes
	 */
	public Transportgut(String name, int anzahl) {
		super(name, anzahl);
	}

	/**
	 * Voll Parametrisierter Konstruktor
	 * 
	 * @param name        Bezeichnung des Gutes
	 * @param anzahl      Anzahl des Gutes
	 * @param laengeMeter Wie Lang das Gut ist (in Metern)
	 * @param breiteMeter Wie Breit das Gut ist (in Metern)
	 * @param hoeheMeter  Wie Hoch das Gut ist (in Metern)
	 */
	public Transportgut(String name, int anzahl, float laengeMeter, float breiteMeter, float hoeheMeter) {
		super(name, anzahl);

		this.laengeMeter = laengeMeter;
		this.breiteMeter = breiteMeter;
		this.hoeheMeter = hoeheMeter;
	}

	public float getLaengeMeter() {
		return laengeMeter;
	}

	public void setLaengeMeter(float laengeMeter) {
		this.laengeMeter = laengeMeter;
	}

	public float getBreiteMeter() {
		return breiteMeter;
	}

	public void setBreiteMeter(float breiteMeter) {
		this.breiteMeter = breiteMeter;
	}

	public float getHoeheMeter() {
		return hoeheMeter;
	}

	public void setHoeheMeter(float hoeheMeter) {
		this.hoeheMeter = hoeheMeter;
	}

	@Override
	public String toString() {
		return String.format("Transport-Gut: %dx %s (Länge: %.2f m, Breite: %.2f m, Höhe: %.2f m)", this.getMenge(),
				this.getBezeichnung(), this.getLaengeMeter(), this.getBreiteMeter(), this.getHoeheMeter());
	}
}
