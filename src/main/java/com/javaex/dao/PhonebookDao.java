package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 삭제
	public int personDelete(int no) {
		System.out.println("PhonebookDao.personDelete()");
		
		int count=sqlSession.delete("phonebook.delete", no);

		return count;
	}

	// 수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("PhonebookDao.personUpdate()");
		
		int count=sqlSession.update("phonebook.update", personVo);

		return count;
	}

	// 수정폼(1개 가져오기)
	public PersonVo personSelectOne(int no) {
		System.out.println("PhonebookDao.personSelectOne()");

		PersonVo personVo=sqlSession.selectOne("phonebook.selectOne", no);

		return personVo;
	}
	
	// 수정폼2(1개 가져오기)
	public Map<String, Object> personSelectOne2(int no) {
		System.out.println("PhonebookDao.personSelectOne2()");

		Map<String, Object> pMap=sqlSession.selectOne("phonebook.selectOne2", no);
		/*
		System.out.println(pMap.get("personId"));
		System.out.println(pMap.get("name"));
		System.out.println(pMap.get("hp"));
		System.out.println(pMap.get("company"));
		*/
		return pMap;
	}

	// 등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");
		
		int count=sqlSession.insert("phonebook.insert", personVo);

		return count;
	}
	
	//등록2
	public int personInsert2(Map<String, String> pMap) {
		System.out.println("PhonebookDao.personInsert2()");
		System.out.println(pMap);
		
		sqlSession.insert("phonebook.insert2", pMap);
		
		return 0;
	}

	// 전체 가져오기
	public List<PersonVo> personSelect() {
		System.out.println("PhonebookDao.personSelect()");

		List<PersonVo> personList=sqlSession.selectList("phonebook.select");
		System.out.println(personList);

		return personList;
	}
	
}
