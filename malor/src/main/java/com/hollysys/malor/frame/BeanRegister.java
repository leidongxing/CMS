package com.hollysys.malor.frame;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.fastjson.JSON;

public class BeanRegister implements ApplicationContextAware {
	private ApplicationContext context = null;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	public void addBeanService(String beanName, String beanClass, Map<String, Object> beanPropertyValue) {
		if (!context.containsBean(beanName)) {
			Class<?> malorClass = getmalorClass(beanClass);
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(malorClass);
			Set<String> key = beanPropertyValue.keySet();
			for (Iterator<String> iterator = key.iterator(); iterator.hasNext();) {
				String elem = (String) iterator.next();
				beanDefinitionBuilder.addPropertyValue(elem,beanPropertyValue.get(elem));
			}
			try {
				registerBean(beanName,beanDefinitionBuilder.getRawBeanDefinition());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized Object addAndReturnBeanService(String beanName,String beanClass, Map<String, Object> beanPropertyValue) {
		if (!context.containsBean(beanName)) {
			Class<?> malorClass = getmalorClass(beanClass);
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(malorClass);
			Set<String> key = beanPropertyValue.keySet();
			for (Iterator<String> iterator = key.iterator(); iterator.hasNext();) {
				String elem = (String) iterator.next();
				beanDefinitionBuilder.addPropertyValue(elem,beanPropertyValue.get(elem));
			}
			try {
				registerBean(beanName,beanDefinitionBuilder.getRawBeanDefinition());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return context.getBean(beanName);
	}

	private void registerBean(String beanName, BeanDefinition beanDefinition) {
		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) context;
		BeanDefinitionRegistry beanDefinitonRegistry = (BeanDefinitionRegistry) configurableApplicationContext.getBeanFactory();

		beanDefinition.setScope("prototype");
		beanDefinitonRegistry.registerBeanDefinition(beanName, beanDefinition);
	}

	public Class<?> getmalorClass(String className) {
		try {
			return Thread.currentThread().getContextClassLoader().loadClass(className);
		} catch (ClassNotFoundException e) {
			LogUtil.error(e);
			throw new MalorException(-900010, "【平台基础层异常】:原子业务对象注册异常"+ JSON.parseObject(e.getMessage()), "0");	
		}
	}
}