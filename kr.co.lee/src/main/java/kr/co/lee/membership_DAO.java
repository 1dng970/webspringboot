package kr.co.lee;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component: @Controller, service, Repository가 모두 포함된 어노테이션
//@Service: 클래스를 해당 코드 로직에 정보를 담고 있는 어노테이션 이며, 인터페이스 호출 시 작동되는 클래스
//서비스는 무조건 클래스에 붙여서 사용, @Autowired로만 호춣ㅇ=해야함
@Service

public class membership_DAO implements membership_service {

   Logger log = LoggerFactory.getLogger(this.getClass());
   
   @Autowired
   private mapper mp; //Mapper을 이용하여 쿼리문 실행 
   
   @Override
	public int join_member(membership_DTO dto) {
		int result = this.mp.save_member(dto);
		return result;
	}
   
  
   @Override
   public List<membership_DTO> alldata() {
       List<membership_DTO> all = this.mp.alldata();
//       log.info = null; 
       this.log.atInfo();
      return all;
   }
   
   
}
