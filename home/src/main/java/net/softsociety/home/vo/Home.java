package net.softsociety.home.vo;

public class Home {
	int num1;
	int num2;
	String gi;
	
	public Home() {}
	
	public Home(int num1, int num2, String gi) {
		this.num1 = num1;
		this.num2 = num2;
		this.gi = gi;
	}
	
	public String getGi() {
		return gi;
	}

	public void setGi(String gi) {
		this.gi = gi;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	@Override
	public String toString() {
		return "";
	}
	
	
}
