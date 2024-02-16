package designPattern.builder;

/**
 * 자바 빈 패턴
 * 불변성 문제가 있음. (Setter를 열어두면, 다른 곳에서 변경 가능성이 있기에.)
 */
public class HamburgerJavaBeans {
	// 필수 매개변수
	private int bun;
	private int patty;

	// 선택 매개변수
	private int cheese;
	private int lettuce;
	private int tomato;
	private int bacon;

	public void setBun(int bun) {
		this.bun = bun;
	}

	public void setPatty(int patty) {
		this.patty = patty;
	}

	public void setCheese(int cheese) {
		this.cheese = cheese;
	}

	public void setLettuce(int lettuce) {
		this.lettuce = lettuce;
	}

	public void setTomato(int tomato) {
		this.tomato = tomato;
	}

	public void setBacon(int bacon) {
		this.bacon = bacon;
	}
}