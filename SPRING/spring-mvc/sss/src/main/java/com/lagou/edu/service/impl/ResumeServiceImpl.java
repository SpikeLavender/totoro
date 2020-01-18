package com.lagou.edu.service.impl;

import com.lagou.edu.dao.ResumeDao;
import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDao resumeDao;

	@Override
	public List<Resume> queryResumeAll() {
		return resumeDao.findAll();
	}

	@Override
	public void deleteById(Long id) {
		resumeDao.deleteById(id);
	}

	@Override
	public Resume addResumeOne(Resume resume) {
		return resumeDao.save(resume);
	}



}
