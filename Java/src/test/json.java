package test;

public class json {
	public static boolean validateName(String json) {
		int start = json.indexOf("\"name\"");
		if (start == -1)
			return false;

		int colon = json.indexOf(":", start);
		int firstQuote = json.indexOf("\"", colon + 1);
		int secondQuote = json.indexOf("\"", firstQuote + 1);

		String name = json.substring(firstQuote + 1, secondQuote);
		System.out.println(name);
		return name.matches("[A-Za-z]+");
	}

	public static void main(String[] args) {
		String json = "{ \"age\": 21, \"name\": \"Shravan\" }";

		boolean isValid = validateName(json);

		System.out.println("Name valid? " + isValid);
	}

}
