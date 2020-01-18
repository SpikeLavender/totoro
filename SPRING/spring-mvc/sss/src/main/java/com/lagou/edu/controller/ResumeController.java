package com.lagou.edu.controller;

import com.lagou.edu.pojo.Resume;
import com.lagou.edu.pojo.User;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/demo")
public class ResumeController {


	@Autowired
	private ResumeService resumeService;


	@RequestMapping(value = "/load", method = {RequestMethod.POST})
	public ModelAndView load(String username, String password) {

		ModelAndView modelAndView = new ModelAndView();
		if (username.equals("admin") && password.equals("admin")) {
			modelAndView.addObject("token", "true");
			modelAndView.setViewName("resume");
		} else {
			modelAndView.setViewName("load");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/resume", method = RequestMethod.GET)
	@ResponseBody
	public List<Resume> resumes() {
		List<Resume> list = resumeService.queryResumeAll();
		System.out.println(list);

		return list;
	}

	@RequestMapping(value = "/resume", method = RequestMethod.POST)
	@ResponseBody
	public Resume addResume(@RequestBody Resume resume) {
		return resumeService.addResumeOne(resume);
	}


	@RequestMapping(value = "/resume/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Resume updateResume(@PathVariable("id") Long id,
	                           @RequestBody Resume resume) {
		resume.setId(id);
		return resumeService.addResumeOne(resume);
	}

	@RequestMapping(value = "/resume/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteResume(@PathVariable("id") Long id) {
		resumeService.deleteById(id);
		return true;
	}

}
