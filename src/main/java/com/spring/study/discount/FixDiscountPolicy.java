package com.spring.study.discount;

import com.spring.study.member.Grade;
import com.spring.study.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;   // 1000원할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {    // enum은 ==으로 같은지 확인
            return discountFixAmount;
        }
        else {
            return 0;
        }
    }
}
