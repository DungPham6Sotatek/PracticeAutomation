package automation.constant;

public enum Element {
	INPUT_SEARCH("gh-ac");
	
	private final String value;
	Element(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
