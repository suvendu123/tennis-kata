
public enum Point {
	Love(0), Fifteen(1), Thirty(2), Deuce(3);
	private int value;

	Point(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}
	
	
}
