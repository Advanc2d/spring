package com.spring.study;

import com.spring.study.member.Grade;
import com.spring.study.member.Member;
import com.spring.study.member.MemberService;
import com.spring.study.member.MemberServiceImpl;
import com.spring.study.order.Order;
import com.spring.study.order.OrderService;
import com.spring.study.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "phm", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "OrderItem1", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
