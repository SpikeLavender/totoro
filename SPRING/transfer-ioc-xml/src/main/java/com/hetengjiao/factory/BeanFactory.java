package com.hetengjiao.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.management.ReflectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {

	private static Map<String, Object> beanMap = new HashMap<>();

	static {
		InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(resourceAsStream);
			Element rootElement = document.getRootElement();
			List<Element> beans = rootElement.selectNodes("//bean");
			for (int i = 0; i < beans.size(); i++) {
				Element element = beans.get(i);
				String id = element.attributeValue("id");
				String clazz = element.attributeValue("class");
				Class<?> aClass = Class.forName(clazz);
				Object o = aClass.newInstance();
				beanMap.put(id, o);
			}

			List<Element> properties = rootElement.selectNodes("//property");
			for (int j = 0; j < properties.size(); j++) {
				Element element = properties.get(j);
				String name = element.attributeValue("name");
				String ref = element.attributeValue("ref");
				Element parent = element.getParent();
				String parentId = parent.attributeValue("id");
				Object parentObj = beanMap.get(parentId);
				Method[] methods = parentObj.getClass().getMethods();
				for (int i = 0; i < methods.length; i++) {
					Method method = methods[i];
					if (method.getName().equalsIgnoreCase("set" + name)) {
						method.invoke(parentObj, beanMap.get(ref));
					}
				}
				beanMap.put(parentId, parentObj);
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (ReflectiveOperationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static Object getBean(String id) {
		return beanMap.get(id);
	}
}
