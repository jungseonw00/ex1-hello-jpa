package designPattern.templateMethod;

public class RateDiscountPolicy implements DiscountPolicy {

	@Override
	public int calculate(int value) {
		return value - value / 10;
	}
}
