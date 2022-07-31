package com.gientech.springbucks.service;

public interface CacheService {

	<K, V> void add(K key, V value);
	
	<K> String get(K key);
	
	void delete(String key);
}
