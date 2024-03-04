package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneBookController {

	// 필드
	@Autowired
	private PhonebookService phonebookService;

	// 생성자

	// 메소드 gs

	// 메소드 일반
	
	//리스트
	@RequestMapping(value="/phone/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhonebookController.list()");
		
		//PhonebookService phonebookService=new PhonebookService();
		List<PersonVo> personList=phonebookService.exeList();
		/*
		PhonebookDao phonebookDao=new PhonebookDao();
		
		List<PersonVo> personList=phonebookDao.personSelect();
		//System.out.println(personList);
		*/
		model.addAttribute("pList", personList);
		
		return "list";
	}
	
	//삭제
	@RequestMapping(value="/phone/delete", method={RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int no) {
		System.out.println("PhonebookController.delete()");
		
		//System.out.println(no);
		/*
		PhonebookDao phonebookDao=new PhonebookDao();
		phonebookDao.personDelete(no);
		*/
		
		phonebookService.exeDelete(no);
		
		return "redirect:/phone/list";
	}
	
	//수정폼
	@RequestMapping(value="/phone/modifyform", method={RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam(value="no") int no, Model model) {
		System.out.println("PhonebookController.modifyForm()");
		
		//PhonebookService phonebookService=new PhonebookService();
		PersonVo personVo=phonebookService.exeModifyForm(no);
		
		/*
		System.out.println(no);
		
		PhonebookDao phonebookDao=new PhonebookDao();
		PersonVo personVo=phonebookDao.personSelectOne(no);
		*/
		model.addAttribute("personVo", personVo);
		
		return "modifyForm";
	}
	
	//수정폼2
	@RequestMapping(value="/phone/modifyform2", method={RequestMethod.GET, RequestMethod.POST})
	public String modifyForm2(@RequestParam(value="no") int no, Model model) {
		System.out.println("PhonebookController.modifyForm2()");
		
		Map<String, Object> pMap=phonebookService.exeModifyForm2(no);
		System.out.println(pMap);
		
		
		model.addAttribute("pMap", pMap);
		
		return "modifyForm2";
	}
	
	//수정
	@RequestMapping(value="/phone/modify", method={RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.modify()");
		
		phonebookService.exeModify(personVo);
		/*
		System.out.println(personVo);
		
		PhonebookDao phonebookDao=new PhonebookDao();
		phonebookDao.personUpdate(personVo);
		*/
		return "redirect:/phone/list";
	}

	// 등록폼
	// /localhost:8080/phonebook5/phone/writeform
	@RequestMapping(value="/phone/writeform", method={RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");
		
		return "aaaaas";
	}
	
	// 등록
	// /localhost:8080/phonebook5/phone/write?name=고다솜&hp=010&company=himedia
	@RequestMapping(value="/phone/write", method={RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write()");
		
		System.out.println(personVo.toString());
		
		//서비스를 메모리에 올린다
		//PhonebookService phonebookService=new PhonebookService();
		
		//서비스의 메소드를 사용한다
		phonebookService.exeWrite(personVo);
				
		//리스트로 리다이렉트
		return "redirect:/phone/list";
		
	}
	
	// 등록2
	// /localhost:8080/phonebook5/phone/write?name=고다솜&hp=010&company=himedia
	@RequestMapping(value="/phone/write2", method={RequestMethod.GET, RequestMethod.POST})
	public String write2(@RequestParam(value="name") String name,
					  @RequestParam(value="hp") String hp,
					  @RequestParam(value="company") String company) {
		System.out.println("PhonebookController.write2()");
		
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		phonebookService.exeWrite2(name, hp, company);
		
		return "redirect:/phone/list";
	}

}
