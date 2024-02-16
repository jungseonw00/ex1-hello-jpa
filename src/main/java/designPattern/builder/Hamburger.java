package designPattern.builder;

/**
 * 점층적 생성자 패턴
 * 다양한 매개변수를 받기 위해서 여러개의 생성자를 만들어야 하는 단점이 있음.
 */
public class Hamburger {
	// 필수 매개변수
	private int bun;
	private int patty;

	// 선택 매개변수
	private int cheese;
	private int lettuce;
	private int tomato;
	private int bacon;

	public Hamburger(int bun, int patty, int cheese, int lettuce, int tomato, int bacon) {
		this.bun = bun;
		this.patty = patty;
		this.cheese = cheese;
		this.lettuce = lettuce;
		this.tomato = tomato;
		this.bacon = bacon;
	}

	public Hamburger(int bun, int patty, int cheese, int lettuce, int tomato) {
		this.bun = bun;
		this.patty = patty;
		this.cheese = cheese;
		this.lettuce = lettuce;
		this.tomato = tomato;
	}


	public Hamburger(int bun, int patty, int cheese, int lettuce) {
		this.bun = bun;
		this.patty = patty;
		this.cheese = cheese;
		this.lettuce = lettuce;
	}

	public Hamburger(int bun, int patty, int cheese) {
		this.bun = bun;
		this.patty = patty;
		this.cheese = cheese;
	}

	public Hamburger(int bun, int patty) {
		this.bun = bun;
		this.patty = patty;
	}
}