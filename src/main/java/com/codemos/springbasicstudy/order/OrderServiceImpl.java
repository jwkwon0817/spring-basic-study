package com.codemos.springbasicstudy.order;

import com.codemos.springbasicstudy.annotation.MainDiscountPolicy;
import com.codemos.springbasicstudy.discount.DiscountPolicy;
import com.codemos.springbasicstudy.member.Member;
import com.codemos.springbasicstudy.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
	
	// Test
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
