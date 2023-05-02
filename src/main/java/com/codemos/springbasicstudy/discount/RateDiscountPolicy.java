package com.codemos.springbasicstudy.discount;

import com.codemos.springbasicstudy.annotation.MainDiscountPolicy;
import com.codemos.springbasicstudy.member.Grade;
import com.codemos.springbasicstudy.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
	private int discountPercent = 10;
	
	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		} else {
			return 0;
		}
	}
}
