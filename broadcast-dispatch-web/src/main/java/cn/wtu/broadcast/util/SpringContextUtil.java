package cn.wtu.broadcast.util;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
	/**
	 * 获取spring容器，以访问容器中定义的其他bean
	 */
	private static ApplicationContext context;
	
	private static DefaultListableBeanFactory defaultListableBeanFactory;

	/**
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境
	 *
	 * @param context
	 */
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		SpringContextUtil.context = context;
		SpringContextUtil.defaultListableBeanFactory = (DefaultListableBeanFactory)context.getAutowireCapableBeanFactory();
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return context;
	}

	/**
	 * 获取对象 这里重写了bean方法，起主要作用
	 * 
	 * @param beanName
	 * @return Object 一个以所给名字注册的bean的实例
	 * @throws BeansException
	 */

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) throws BeansException {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
		String className = clazz.getName();
		defaultListableBeanFactory.registerBeanDefinition(className, beanDefinitionBuilder.getBeanDefinition());
		return (T) context.getBean(className);
	}

	public static void destroy(String className) {
		defaultListableBeanFactory.removeBeanDefinition(className);
		context = null;
	}

	public static String getMessage(String key) {
		return context.getMessage(key, null, Locale.getDefault());
	}
}