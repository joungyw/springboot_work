package org.example.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Aspect
public class TimeAspect {
    @Pointcut("execution(public * org..*(..))")
    private void publicTarget(){}

    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        LocalTime beforTime = LocalTime.now();
        try {
            Object result = proceedingJoinPoint.proceed();
            return result;
        }
       finally {
            LocalTime afterTime = LocalTime.now();
            System.out.println(LocalTime.now());

        }

    }
}
