package com.spring.study.order;

import com.spring.study.discount.DiscountPolicy;
import com.spring.study.discount.FixDiscountPolicy;
import com.spring.study.discount.RateDiscountPolicy;
import com.spring.study.member.Member;
import com.spring.study.member.MemberRepository;
import com.spring.study.member.MemberService;
import com.spring.study.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
