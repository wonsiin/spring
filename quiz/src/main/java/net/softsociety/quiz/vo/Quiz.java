package net.softsociety.quiz.vo;

public class Quiz {
	String naio1 [];
	String naio2 [];
	int sekai;
	
	public Quiz() {}
	
	public Quiz(String[] naio1, String[] naio2, int sekai) {
		this.naio1 = naio1;
		this.naio2 = naio2;
		this.sekai = sekai;
	}
	
	public String[] getNaio1() {
		return naio1;
	}

	public void setNaio1(String[] naio1) {
		this.naio1 = naio1;
	}

	public String[] getNaio2() {
		return naio2;
	}

	public void setNaio2(String[] naio2) {
		this.naio2 = naio2;
	}

	public int getSekai() {
		return sekai;
	}

	public void setSekai(int sekai) {
		this.sekai = sekai;
	}

	@Override
	public String toString() {
		return "제목 : " + naio1 + " , 내용 : " + naio2 + " , 정답 : " + sekai;
	}

	
}
