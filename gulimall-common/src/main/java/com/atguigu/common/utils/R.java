/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.atguigu.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public com.atguigu.common.utils.R setData(Object data) {
		this.put("data", data);
		return this;
	}



	/**
	 * 将数据反序列化为指定类型并返回，基本对象类型
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public<T> T getData(Class<T> clazz) {
		Object data = this.get("data");
		String jsonString = JSON.toJSONString(data);
		T t = JSON.parseObject(jsonString, clazz);
		return t;
	}

	/**
	 * 将数据反序列化为指定类型并返回，基本对象类型
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public<T> T getData(String key, Class<T> clazz) {
		Object data = this.get(key);
		String jsonString = JSON.toJSONString(data);
		T t = JSON.parseObject(jsonString, clazz);
		return t;
	}

	/**
	 * 将数据反序列化为指定类型并返回，复杂类型，如 List<T>
	 * @param
	 * @param <T>
	 * @return
	 */
	public<T> T getData(TypeReference<T> typeReference) {
		Object data = this.get("data");
		String jsonString = JSON.toJSONString(data);
		T t = JSON.parseObject(jsonString, typeReference);
		return t;
	}
	
	public R() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static com.atguigu.common.utils.R error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static com.atguigu.common.utils.R error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static com.atguigu.common.utils.R error(int code, String msg) {
		com.atguigu.common.utils.R r = new com.atguigu.common.utils.R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static com.atguigu.common.utils.R ok(String msg) {
		com.atguigu.common.utils.R r = new com.atguigu.common.utils.R();
		r.put("msg", msg);
		return r;
	}
	
	public static com.atguigu.common.utils.R ok(Map<String, Object> map) {
		com.atguigu.common.utils.R r = new com.atguigu.common.utils.R();
		r.putAll(map);
		return r;
	}
	
	public static com.atguigu.common.utils.R ok() {
		return new com.atguigu.common.utils.R();
	}

	@Override
	public com.atguigu.common.utils.R put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public Integer getCode() {
		return (Integer) this.get("code");
	}
}
