package com.mh.restapi04.login;

import com.mh.restapi04.excoption.ErrorCode;
import com.mh.restapi04.excoption.UsersException;
import com.mh.restapi04.users.User;
import com.mh.restapi04.users.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


@Component
@RequiredArgsConstructor
public class LoginInterceptor extends InterceptorRegistry implements HandlerInterceptor {

    private final UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("일로오나");
        String password = request.getHeader("password");
        String email = request.getHeader("email");

        System.out.println(password);
        System.out.println(email);

        User dbUser = userRepository.findByEmailAndPassword(email,password);

        if (dbUser == null){
            throw new UsersException(ErrorCode.LOGINFAILED);
    }
         return true;

    }
}
