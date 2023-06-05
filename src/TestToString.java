public class TestToString {
	public static void main(String[] args) {
		Gast borg = new Gast("Borg", 200, "FR", "Delta-Quadranrt", Verpflegung.ALLES_INKLUSIVE);
		System.out.println(borg);

		Transportgut batlethKlingonenSchwert = new Transportgut("Bat'leth Klingonen Schwert", 200, 0.8f, 0.2f, 0.1f);
		System.out.println(batlethKlingonenSchwert);
	}
}
