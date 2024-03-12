package org.example.components;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService  implements InitializingBean, DisposableBean {

    @Autowired
    private  MemberRepository memberRepository;

    private String str;
    public void regist() {
        memberRepository.insert();
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        str = "jdbc:mysql://192.168.";
        System.out.println("IOC 컨테이너 들어갈떄...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("IOC 컨테이너 없어질때...");
    }


}
