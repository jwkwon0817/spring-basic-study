package com.codemos.springbasicstudy.autowired;

import com.codemos.springbasicstudy.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
	@Test
	void AutowiredOption() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
	}
	
	@Configuration
	static class TestBean {
		@Autowired(required = false) // null이면 호출 자체가 안됨
		public void setNoBean1(Member noBean1) {
			System.out.println("noBean1 = " + noBean1);
		}
		
		@Autowired // 호출은 되지만 null이 들어감
		public void setNoBean2(@Nullable Member noBean2) {
			System.out.println("noBean2 = " + noBean2);
		}
		
		@Autowired // Optional.empty가 들어감
		public void setNoBean3(Optional<Member> noBean3) {
			System.out.println("noBean3 = " + noBean3);
		}
	}
}
