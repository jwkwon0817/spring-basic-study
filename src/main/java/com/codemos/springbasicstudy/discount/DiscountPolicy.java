package com.codemos.springbasicstudy.discount;

import com.codemos.springbasicstudy.member.Member;

public interface DiscountPolicy {
	/**
	 * @return discount amount
	 */
	int discount(Member member, int price);
}
