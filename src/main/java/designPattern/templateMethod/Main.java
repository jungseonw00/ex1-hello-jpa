package designPattern.templateMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

	private final DiscountPolicy discountPolicy;

	public Main(DiscountPolicy discountPolicy) {
		this.discountPolicy = discountPolicy;
	}
}
