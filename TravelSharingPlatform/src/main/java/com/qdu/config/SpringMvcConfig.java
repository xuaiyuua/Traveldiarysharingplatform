package com.qdu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//这是一个Spring MVC配置类，用于配置web相关的配置
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer{
	
	//文件上传有很多方式，可以使用配置虚拟路径，将一个虚拟路径映射到一个实际路径
	//从而可以通过虚拟路径来访问实际路径下的文件
	//addResourceHandlers()方法中用于配置一些静态资源（但是因为Spring Boot默认帮你配置了静态资源的访问）
	//通常不需要再添加静态资源的配置了。还可以用于配置虚拟路径。
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/up/**").addResourceLocations("file:C:/upload/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/password").setViewName("user/password");
		//如果希望跳转到templates目录下的某个动态页面，需要经控制器跳转
		//通常在控制器中处理完请求，再指定要跳转的页面
		//但是如果对一个请求不做其他处理，只是跳转页面，可以直接在这里配置
		//这里的配置说明如果发送的请求的url是/to_upload，会跳转到upload页面


		//如果请求的url是/login，跳转到login_page.html页面
		registry.addViewController("/toUserLogin").setViewName("user/user_login");


		////administrator

		registry.addViewController("/admin_login").setViewName("admin/admin_login");



	}
	

	
}
