package model;

import java.math.BigDecimal;

public class Money {

	private BigDecimal value;

	public Money() {
		this("0.00");
	}

	public Money(String value) {
		this.value = new BigDecimal(value);
	}

	public Money add(Money money) {
		return new Money((value.add(money.getValue()).toString()));
	}

	public boolean isGreaterThan(Money money) {
		return this.value.compareTo(money.getValue()) > 0;
	}

	public boolean isEqualTo(Money money) {
		return this.value.compareTo(money.getValue()) == 0;
	}

	public boolean isGreaterThanOrEqualTo(Money money) {
		return isGreaterThan(money) || isEqualTo(money);
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
