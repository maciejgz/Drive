package pl.mg.drivemonolith.logging;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
@Slf4j
public class ApiLoggingAspect {

//    @Pointcut("@target(org.springframework.stereotype.Controller)")
    public void apiMethods() {
    }

//    @Before("apiMethods()")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        log.debug("Before " + methodName);
    }

}
