package Data;

public class Food {

	private String produktName, herstellerName, type;
	private long barcode;
	private IsVegan vegan;

	public Food(String produktName, String herstellerName, String type,
			long barcode, IsVegan vegan) throws Exception {

		setProduktName(produktName);
		setHerstellerName(herstellerName);
		setType(type);
		setBarcode(barcode);
		setVegan(vegan);

	}

	public void setProduktName(String produktName) throws Exception {
		if (produktName == null || produktName.isEmpty()) {

			throw new Exception("Kein Produktname eingegeben!");

		} else if (Character.isLowerCase(produktName.charAt(0))) {

			throw new Exception("Produktname muss mit einem Groﬂbuchstaben anfangen!");

		} else {
			this.produktName = produktName;
		}

	}

	public String getProduktName() {

		return produktName;

	}

	public void setHerstellerName(String herstellerName) throws Exception {
		if (herstellerName == null || herstellerName.isEmpty()) {

			throw new Exception("Kein Herstellername eingegeben!");

		} else if (Character.isLowerCase(herstellerName.charAt(0))) {

			throw new Exception("Herstellername muss mit einem Groﬂbuchstaben anfangen!");

		} else {
			this.herstellerName = herstellerName;
		}

	}

	public String getHerstellerName() {

		return herstellerName;

	}

	public void setType(String type) throws Exception {
		if (type.isEmpty() || type == null) {
			throw new Exception("Kein Typ eingegeben");
		} else if (Character.isLowerCase(type.charAt(0))) {
			throw new Exception("Typ muss Groﬂgeschrieben sein");
		} else {
			this.type = type;

		}

	}

	public String getType() {

		return type;

	}

	public void setBarcode(long barcode) throws Exception {
		if (barcode <= 0) {

			throw new Exception("Kein g¸ltiger Barcode!");

		} else {

			this.barcode = barcode;
		}
	}

	public long getBarcode() {

		return barcode;

	}

	public void setVegan(IsVegan vegan) throws Exception {
		if (vegan.equals(IsVegan.VEGAN) || vegan.equals(IsVegan.VEGETARIAN)
				|| vegan.equals(IsVegan.NONVEGAN)) {
			this.vegan = vegan;
		} else {
			throw new Exception(
					"Entweder vegan, vegetarisch oder nicht vegetarisch");
		}

	}

	public IsVegan getVegan() {

		return vegan;

	}

	public String toString() {

		String attributes = this.getProduktName() + " "
				+ this.getHerstellerName() + " " + " " + this.getType() + " "
				+ new Long(this.getBarcode()).toString();

		if (vegan.equals(IsVegan.VEGAN))
			return attributes.concat(" " + "Vegan");
		if (vegan.equals(IsVegan.VEGETARIAN))
			return attributes.concat(" " + "Vegetarian");
		if (vegan.equals(IsVegan.NONVEGAN))
			return attributes.concat(" " + "not vegetarian");
		return null;

	}
}
