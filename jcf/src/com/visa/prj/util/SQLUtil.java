package com.visa.prj.util;

import java.lang.reflect.Method;

import com.visa.prj.annotations.Column;
import com.visa.prj.annotations.Table;

public class SQLUtil {

	public static String createStatement(Class<?> clazz) {
		//String is immutable, i.e, new object is created for every +=. Therefore use
		//StringBuilder which is immutable.
		StringBuilder builder = new StringBuilder();
		Table t = clazz.getAnnotation(Table.class);
		if (t != null) {
			builder.append("create table");
			builder.append(" ");
			builder.append(t.name());
			builder.append("(");
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				if (m.getName().startsWith("get")) {
					try {
						Column c = m.getAnnotation(Column.class);
						if (c != null) {
							builder.append(c.name());
							builder.append(" ");
							builder.append(c.type());
							builder.append(",");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		builder.setCharAt(builder.lastIndexOf(","), ')');
		return builder.toString();
	}
}
