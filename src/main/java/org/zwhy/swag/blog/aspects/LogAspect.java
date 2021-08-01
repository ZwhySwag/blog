package org.zwhy.swag.blog.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.zwhy.swag.blog.vo.log.LogVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZWHySwag
 * @date 2021\7\26 0026 20:56
 */

@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Pointcut("execution(* org.zwhy.swag.blog.controller.*.*(..))")
    public void log() {}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        LogVO log = new LogVO(url,ip, method,args);
        logger.info("Request info: {}", log);
    }

    @After("log()")
    public void doAfter() {
        logger.info("End logging...");
    }

    @AfterReturning(pointcut = "log()", returning = "result")
    public void doAfterReturn(Object result) {
        logger.info("Result: {}", result);
    }
}
