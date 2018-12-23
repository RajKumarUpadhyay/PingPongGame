package com.rakuten.pingpong.pojo;

public class Matches {

	private int singles;
	private int doubles;
	public Matches(int singles, int doubles) {
		this.singles = singles;
		this.doubles = doubles;
	}
	public int getSingles() {
		return singles;
	}
	public int getDoubles() {
		return doubles;
	}
}
