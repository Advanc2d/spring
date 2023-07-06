package com.spring.study;

import com.spring.study.discount.DiscountPolicy;
import com.spring.study.discount.FixDiscountPolicy;
import com.spring.study.discount.RateDiscountPolicy;
import com.spring.study.member.MemberRepository;
import com.spring.study.member.MemberService;
import com.spring.study.member.MemberServiceImpl;
import com.spring.study.member.MemoryMemberRepository;
import com.spring.study.order.OrderService;
import com.spring.study.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    /* 기본 자바 1

    public MemberService memberService() {

        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(), new FixDiscountPolicy());
    }
    */

    /* 기본 자바2
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
    */

    @Bean
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService()");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService()");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository()");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("Call AppConfig.discountPolicy()");
        return new RateDiscountPolicy();
    }
}
