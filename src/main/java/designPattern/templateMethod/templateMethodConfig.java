package designPattern.templateMethod;

public class templateMethodConfig {

	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}
}
