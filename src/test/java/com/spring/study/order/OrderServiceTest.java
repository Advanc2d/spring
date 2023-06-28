package com.spring.study.order;

import com.spring.study.AppConfig;
import com.spring.study.member.Grade;
import com.spring.study.member.Member;
import com.spring.study.member.MemberService;
import com.spring.study.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        /* 기본 자바 테스트
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
        this.orderService = appConfig.orderService();
        */

        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(AppConfig.class);
        this.memberService =
                applicationContext.getBean("memberService", MemberService.class);
        this.orderService = applicationContext.getBean("orderService",
                OrderService.class);
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "phm", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "OrderItem1", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
