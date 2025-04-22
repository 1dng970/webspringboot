package kr.co.lee;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
@Service implements 를 사용 할 수있는 방법은 다음과 같습니다.
Service라는 interface를 생성 후 @override 형태로 가능함
단, implements @Mapper interface는 절대 로드 하지 못함  
 */
@Service
public class api_service{

	@Autowired
	api_mapper am; //interface를 로드 
	
    public int insert_cms(Map<String, String> map) {
    	int result = this.am.api_insert(map);
    	return result;
    }
    
}
