package com.lagou.edu.service;

import com.lagou.edu.pojo.Resume;

import java.util.List;

public interface ResumeService {
	List<Resume> queryResumeAll();

	void deleteById(Long id);

	Resume addResumeOne(Resume resume);

}
