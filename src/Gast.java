/**
 * Stellt eine spezielle Ladung dar
 * 
 * @author leander.scherwinsky
 *
 */
public class Gast extends Ladung {

	private String sprache;
	private String heimatplanet;
	private Verpflegung verpflegung;

	/**
	 * Leerer Konstruktor
	 */
	public Gast() {
		super();
	}

	/**
	 * Parametrisierter Konstrukroe
	 * 
	 * @param name   Bezeichnung der Gäste
	 * @param anzahl Anzahl der Gäste
	 */
	public Gast(String name, int anzahl) {
		super(name, anzahl);
	}

	/**
	 * Voll Parametrisierter Konstruktor
	 * 
	 * @param name        Bezeichnung der Gäste
	 * @param anzahl      Anzahl der Gäste
	 * @param sprache     Sprache der Gäste
	 * @param planet      Heimatplanet der Gäste
	 * @param verpflegung Die Verpflegungsart der Gäste
	 */
	public Gast(String name, int anzahl, String sprache, String planet, Verpflegung verpflegung) {
		super(name, anzahl);

		this.sprache = sprache;
		this.heimatplanet = planet;
		this.verpflegung = verpflegung;
	}

	public String getSprache() {
		return sprache;
	}

	public void setSprache(String sprache) {
		this.sprache = sprache;
	}

	public String getHeimatplanet() {
		return heimatplanet;
	}

	public void setHeimatplanet(String heimatplanet) {
		this.heimatplanet = heimatplanet;
	}

	public Verpflegung getVerpflegung() {
		return verpflegung;
	}

	public void setVerpflegung(Verpflegung verpflegung) {
		this.verpflegung = verpflegung;
	}

	@Override
	public String toString() {
		return String.format("Gast: %dx %s (Heimatplanet: %s, Sprache: %s, Verpflegungs-Art: %s)", this.getMenge(),
				this.getBezeichnung(), this.getHeimatplanet(), this.getSprache(), this.getVerpflegung());
	}
}
