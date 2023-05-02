package com.codemos.springbasicstudy;

import com.codemos.springbasicstudy.discount.DiscountPolicy;
import com.codemos.springbasicstudy.discount.RateDiscountPolicy;
import com.codemos.springbasicstudy.member.MemberRepository;
import com.codemos.springbasicstudy.member.MemberService;
import com.codemos.springbasicstudy.member.MemberServiceImpl;
import com.codemos.springbasicstudy.member.MemoryMemberRepository;
import com.codemos.springbasicstudy.order.OrderService;
import com.codemos.springbasicstudy.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public MemberService memberService() {
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}
	
	@Bean
	public OrderService orderService() {
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}
}
