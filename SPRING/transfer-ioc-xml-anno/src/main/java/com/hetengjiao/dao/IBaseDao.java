package com.hetengjiao.dao;

public interface IBaseDao<T> {
	T queryById(int id) throws Exception;
}
