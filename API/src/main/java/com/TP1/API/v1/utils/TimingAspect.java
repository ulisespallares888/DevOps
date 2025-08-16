package com.TP1.API.v1.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimingAspect {

    @Around("execution(* com.TP1.API.v1.modules.task.controller.*.*(..))")
    public Object medirTiempoDeEjecucion(ProceedingJoinPoint joinPoint) throws Throwable {
        long inicio = System.currentTimeMillis();

        Object resultado = joinPoint.proceed();

        long fin = System.currentTimeMillis();

        log.info("★★★★ {} tardó {} ms ★★★★",joinPoint.getSignature().getName(), fin - inicio);

        return resultado;
    }
}
