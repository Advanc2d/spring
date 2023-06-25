package com.spring.study;

import com.spring.study.discount.FixDiscountPolicy;
import com.spring.study.member.MemberService;
import com.spring.study.member.MemberServiceImpl;
import com.spring.study.member.MemoryMemberRepository;
import com.spring.study.order.OrderService;
import com.spring.study.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
