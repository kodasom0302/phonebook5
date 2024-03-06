package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	@Autowired
	private PhonebookDao phonebookDao;
	
	//수정폼
	public PersonVo exeModifyForm(int no) {
		System.out.println("PhonebookService.exeModifyForm()");
		
		//PhonebookDao phonebookDao=new PhonebookDao();
		PersonVo personVo=phonebookDao.personSelectOne(no);
		
		return personVo;
	}
	
	//수정폼2
		public Map<String, Object> exeModifyForm2(int no) {
			System.out.println("PhonebookService.exeModifyForm2()");
			
			Map<String, Object> pMap=phonebookDao.personSelectOne2(no);
			
			return pMap;
		}
	
	//등록
	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");
		
		//비즈니스 로직 - 현재는 없음
		//PhonebookDao phonebookDao=new PhonebookDao();
		int count=phonebookDao.personInsert(personVo);
		
		return count;
	}
	
	//등록2
	public int exeWrite2(String name, String hp, String company) {
		System.out.println("PhonebookService.exeWrite2()");
		
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		//PersonVo를 제작해서 묶는다 -> 딱 한 번만 사용할 것 같음
		Map<String, String> personMap=new HashMap<String, String>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		
		phonebookDao.personInsert2(personMap);
		
		return 0;
	}
	
	//수정
	public int exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeModify()");
		
		//PhonebookDao phonebookDao=new PhonebookDao();
		int count=phonebookDao.personUpdate(personVo);
		
		return count;
	}
	
	//삭제
	public int exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete()");
		
		//PhonebookDao phonebookDao=new PhonebookDao();
		int count=phonebookDao.personDelete(no);
		
		return count;
	}
	
	//리스트
	public List<PersonVo> exeList() {
		System.out.println("PhonebookService.exeList()");
		
		//PhonebookDao phonebookDao=new PhonebookDao();
		List<PersonVo> personList=phonebookDao.personSelect();
		
		return personList;
	}

}
