package de.htw_berlin.ai_bachelor.kbe.util;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public abstract class Singelton {
	private static final Map<String, Object> instances = new HashMap<>();
	
	public synchronized static <T> T of(Class<T> type) {
		if ( !isSingelton(type) ) {
			try {
				Constructor<T> constructor = type.getDeclaredConstructor();
				constructor.setAccessible(true);
				instances.put(type.getName(), constructor.newInstance());
			} catch (Exception e) {
				throw new IllegalArgumentException("The Singelton class required a constructor without arguments", e);
			}
		} 
		
		Object instance = instances.get(type.getName());
		return type.cast(instance);
	}

	public synchronized void register(Object object) {
		if ( isSingelton(object.getClass())) {
			throw new IllegalStateException("The type of the specified object was already registered as singelton");
		}	
		instances.put(object.getClass().getName(), object);
	}
	
	public synchronized void unregister(Object object) {	
		instances.remove(object.getClass().getName());
	
	}
	
	private synchronized static <T> boolean isSingelton(Class<T> type) {
		return instances.containsKey(type.getName());
	}

}
