package designPattern.templateMethod;

public class FixDiscountPolicy implements DiscountPolicy {

	@Override
	public int calculate(int value) {
		return value - 1000;
	}
}
