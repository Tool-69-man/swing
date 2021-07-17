package com.iflytek.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	
	
	/**
	 * 数据源对象
	 */
	private static ComboPooledDataSource myDataSource = new ComboPooledDataSource();
	
	/**
	   *    获得我的xml配置的数据库源
	 * @return
	 */
	public static ComboPooledDataSource getDataSource(){
		return myDataSource;
	}
	
}
