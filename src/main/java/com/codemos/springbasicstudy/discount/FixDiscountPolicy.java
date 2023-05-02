package com.codemos.springbasicstudy.discount;

import com.codemos.springbasicstudy.member.Grade;
import com.codemos.springbasicstudy.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {
	private int discountFixAmount = 1000; // discount 1000 won
	
	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
	}
}
