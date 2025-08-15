package com.TP1.API.v1.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimingAspect {

    @Around("execution(* com.TP1.API.task.controller.*.*(..))")
    public Object medirTiempoDeEjecucion(ProceedingJoinPoint joinPoint) throws Throwable {
        long inicio = System.currentTimeMillis();

        Object resultado = joinPoint.proceed();

        long fin = System.currentTimeMillis();
        System.out.println("############## "+joinPoint.getSignature() + " ejecutado en " + (fin - inicio) + " ms");

        return resultado;
    }
}
