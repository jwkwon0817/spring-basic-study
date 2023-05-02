package com.codemos.springbasicstudy.discount;

import com.codemos.springbasicstudy.member.Grade;
import com.codemos.springbasicstudy.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP should get 10% discount")
	void vipSuccess() {
		// given
		Member member = new Member(1L, "member", Grade.VIP);
		
		// when
		int discount = discountPolicy.discount(member, 10000);
		
		// then
		assertThat(discount).isEqualTo(1000);
	}
	
	@Test
	@DisplayName("Default should not get 10% discount")
	void vipFail() {
		// given
		Member member = new Member(2L, "memberBASIC", Grade.BASIC);
		
		// when
		int discount = discountPolicy.discount(member, 10000);
		
		// then
		assertThat(discount).isEqualTo(0);
	}
}