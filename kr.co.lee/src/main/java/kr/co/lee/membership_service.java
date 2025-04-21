package kr.co.lee;

import java.util.List;
//@Service에서는 
//해당 class에서 @Override 메소드를 실행함 => @Controller에서 interface 로드 
public interface membership_service {
	List<membership_DTO> alldata();
	int join_member(membership_DTO dto);
}
