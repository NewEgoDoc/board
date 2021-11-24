package com.example.board.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class RoundAdvice {
	public Object roundLog(ProceedingJoinPoint pjp) throws Throwable {
		//먼저 해야 할 일... (Before 어드바이스 작업)
		String method = pjp.getSignature().getName();
		long startTime = System.currentTimeMillis();
		
		Object rtnObj =pjp.proceed();
		
		//메서드 실행 후 해야 할 일...(After 어드바이스 작업)
		long methodExecuteTime = System.currentTimeMillis() - startTime;
		System.out.println(method + "() 메서드 수행시간 : " + methodExecuteTime);
		
		return rtnObj;
	}
}
