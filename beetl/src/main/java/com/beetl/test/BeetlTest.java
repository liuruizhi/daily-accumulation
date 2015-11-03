package com.beetl.test;

import java.io.IOException;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

public class BeetlTest {
	public static void main(String[] args) throws IOException {
		StringTemplateResourceLoader strl = new StringTemplateResourceLoader();
		Configuration configuration = Configuration.defaultConfiguration();
		String reg = "hello ${beetl}";
		GroupTemplate groupTemplate = new GroupTemplate(strl, configuration);
		Template t = groupTemplate.getTemplate(reg);
		t.binding("beetl", "world");
		String str = t.render();
		System.out.println(str);
	}
}
