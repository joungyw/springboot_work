package com.GIT.ex03;

import com.GIT.ex03.component.BB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ex03Application {

    public static void main(String[] args)
	{
		SpringApplication.run(Ex03Application.class, args);
		
    }

	@Bean
	public BB bb(){
		return new BB();
	}
}
