package com.GIT.ex03.conf;

import com.GIT.ex03.component.AA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MtConf2 {

    @Bean
    public AA aa(){
        return new AA();
    }
}
