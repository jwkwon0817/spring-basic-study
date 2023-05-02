package com.codemos.springbasicstudy.scan;

import com.codemos.springbasicstudy.AutoAppConfig;
import com.codemos.springbasicstudy.member.MemberRepository;
import com.codemos.springbasicstudy.member.MemberService;
import com.codemos.springbasicstudy.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {
	@Test
	void basicScan() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		
		MemberService memberService = ac.getBean(MemberService.class);
		
		assertThat(memberService).isInstanceOf(MemberService.class);
		
		OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
		MemberRepository memberRepository = bean.getMemberRepository();
		System.out.println("memberRepository = " + memberRepository);
	}
}
