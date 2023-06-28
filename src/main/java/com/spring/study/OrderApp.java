package com.spring.study;

import com.spring.study.member.Grade;
import com.spring.study.member.Member;
import com.spring.study.member.MemberService;
import com.spring.study.order.Order;
import com.spring.study.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        /* 기본 자바
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        */

        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =
                applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",
                OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "phm", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "OrderItem1", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
