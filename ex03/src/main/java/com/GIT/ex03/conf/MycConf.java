package com.GIT.ex03.conf;

import com.GIT.ex03.member.MemberRepository;
import com.GIT.ex03.member.MemberService;
import com.GIT.ex03.myanno.ManualBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
/*
memberController
memberservice
memberRepository
Member

regist ->
list
 */

@Configuration
@ComponentScan(value = "aa.bb.cc",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ManualBean.class)
        })
public class MycConf {
    @Bean
    public MemberService memberService() {
        return new MemberService();
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepository();
    }

}
