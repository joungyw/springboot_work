package org.example;


import org.example.conf.MyConf;
import org.example.member.Member;
import org.example.member.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConf.class);

        Member member1 = Member.builder()
                .emil("aaa@naver.com")
                .password("1234")
                .name("홍길동")
                .wdate(LocalDateTime.now())
                .build();

        Member member2 = Member.builder()
                .emil("bbb@naver.com")
                .password("5678")
                .name("김길동")
                .wdate(LocalDateTime.now())
                .build();
        MemberService memberService = context.getBean(MemberService.class);
        memberService.Regist(member1);
        memberService.Regist(member2);

        memberService.list();

//        int[] arr = {10,20,30,40,50};
//        for (int temp : arr){
//            System.out.println(temp);
//        }
//        Arrays.stream(arr).forEach(System.out::println);
//
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter
//                = DateTimeFormatter.ofPattern("yyyy년MM월dd일 hh:mm:ss");
//        System.out.println(formatter.format(now));

//        String[] str = context.getBeanDefinitionNames();
//        Arrays.stream(str).forEach(item -> System.out.println(item));

//        context.close();
    }
}