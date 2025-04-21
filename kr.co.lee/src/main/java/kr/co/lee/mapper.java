package kr.co.lee;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//Mapper => 무조건 interface 임
@Mapper
public interface mapper {
	List<membership_DTO> onedate(String MID);	//하나의 데이터
	List<membership_DTO> alldata();
	int save_member(membership_DTO dto);
}
