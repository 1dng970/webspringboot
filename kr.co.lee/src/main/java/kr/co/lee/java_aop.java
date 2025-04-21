package kr.co.lee;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//AOP를 적용할 Class 

/*
 OOP : 객체 지향 언어 
 AOP(Aspect-Orient Programming) : 관점 지향 언어 
 */
public class java_aop {
	
	public static void main(String[] args) {
		
		//AOP (Proxy) => newProxyInstance => 기존메소드 + 신규코드 return
		/*
		 Proxy.newProxyInstance : 동적 프록시 ClassLoad 역할
		 Class : 프록시 클래스가 구현할 인터페이지 목록(배열) 
		  
		 */
		
		examinterface ex = new exam();		
	  //AOP 사용
		examinterface aops = 
				(examinterface)Proxy.newProxyInstance(examinterface.class.getClassLoader(),
				new Class[] {examinterface.class},
				new InvocationHandler() {
					
					@Override
					public Integer invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						String user[] = {"hong","kim"};
						List<String> all = new ArrayList<>();
						int ww = 0;
						while(ww<user.length) {
                       all.add(user[ww]);							
						ww++;
						}
						//해당 본코드의 메소드를 실행시키는 결과값을 가져오는 역할
						Object result = method.invoke(ex, args);
						int total2 = Integer.parseInt(result.toString()) + 100;				
						return total2;
					}					
		});
		int result = ex.total();
		System.out.println("본코드에서 실행된 결과값 : " + result);
		int result_aop = aops.total();//map으로 받음
		System.out.println("AOP에서 실행된 결과값 : " + result_aop);
		
		int result_aop2 = aops.avg();
		System.out.println("AOP에서 실행된 결과값2: " + result_aop2);
		
	}
		
}
