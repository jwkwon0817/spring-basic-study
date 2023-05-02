package com.codemos.springbasicstudy.singleton;

import com.codemos.springbasicstudy.AppConfig;
import com.codemos.springbasicstudy.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
	@Test
	@DisplayName("Pure DI container without Spring")
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		
		// 1. 조회: 호출할 때마다 객체를 생성
		MemberService memberService1 = appConfig.memberService();
		
		// 2. 조회: 호출할 때 마다 객체를 생성
		MemberService memberService2 = appConfig.memberService();
		
		// 참조값이 다른 것을 확인
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);
		
		// memberService1 != memberService2
		assertThat(memberService1).isNotSameAs(memberService2);
	}
	
	@Test
	@DisplayName("Singleton pattern")
	void singletonServiceTest() {
		SingletonService singletonService1 = SingletonService.getInstance();
		SingletonService singletonService2 = SingletonService.getInstance();
		
		System.out.println("singletonService1 = " + singletonService1);
		System.out.println("singletonService2 = " + singletonService2);
		
		assertThat(singletonService1).isSameAs(singletonService2);
	}
	
	@Test
	@DisplayName("Spring container and singleton")
	void springContainer() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// 1. 조회: 호출할 때마다 객체를 생성
		MemberService memberService1 = ac.getBean("memberService", MemberService.class);
		
		// 2. 조회: 호출할 때 마다 객체를 생성
		MemberService memberService2 = ac.getBean("memberService", MemberService.class);
		
		// 참조값이 다른 것을 확인
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);
		
		// memberService1 != memberService2
		assertThat(memberService1).isSameAs(memberService2);
	}
}
