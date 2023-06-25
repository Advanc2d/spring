package com.spring.study;

import com.spring.study.member.Grade;
import com.spring.study.member.Member;
import com.spring.study.member.MemberService;
import com.spring.study.member.MemberServiceImpl;

import java.util.Arrays;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "phm", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
