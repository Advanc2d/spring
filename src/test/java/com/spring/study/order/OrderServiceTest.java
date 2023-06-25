package com.spring.study.order;

import com.spring.study.AppConfig;
import com.spring.study.member.Grade;
import com.spring.study.member.Member;
import com.spring.study.member.MemberService;
import com.spring.study.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
        this.orderService = appConfig.orderService();
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
