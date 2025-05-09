package com.qdu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	//为了保证密码的安全性，通常会使用一些加密算法对密码加密，然后存储密文
	//Bcrypt是加密算法之一，而且是加盐加密算法
	//这里添加一个方法，注册一个密码加密器成为spring管理的组件，
	//这样我们在需要使用密码加密器的地方直接依赖注入即可
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



	//configure(AuthenticationManagerBuilder auth)方法中用于配置用户信息和其角色
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//密码通常是加密存储的，可以通过使用密码加密器对密码加密
		//passwordEncoder()方法用于指定使用的密码加密器
		//如果希望密码被理解为明文，可以使用NoOpPasswordEncoder
		//它会将密码作为明文理解，该密码加密器实际开发中不建议使用，只是测试程序用
		//如果使用加密算法，passwordEncoder()中传入使用的加密器，这里调用上面的passwordEncoder()方法
		//获取加密器，传入方法
		//本程序使用数据库中的用户数据验证用户，所以这里调用userDetailsService()方法指定
		//使用的UserDetailsService实例，该实例说明了如何从数据库加载用户数据
//		auth.userDetailsService(udService)
//				.passwordEncoder(passwordEncoder());
	}

	// configure(WebSecurity web) 方法中用于配置需要忽略，不进行拦截的资源的url
	// 主要是一些静态资源，包括css、图片、js
	@Override
	public void configure(WebSecurity web) throws Exception {
		// ant是一种url书写方式，如/css/style.css, /css/home/aa/bbb/style.css
		// 在ant风格url中，可以使用一些通配符
		// ? 表示任意的单个字符
		// * 任意的字符串，通常用于匹配单级路径 /css/*
		// ** 可用于匹配任意的多级路径 /css/**
		// antMatchers()方法的一个形态是接受String...类型的参数，也就是说可以接受任意多个字符串
		web.ignoring().antMatchers("/css/**","/fonts/**", "/js/**", "/img/**");
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 这里采用允许所有请求的方式，相当于禁用了安全验证，实际等同于不启用Spring Security的效果
		http.authorizeRequests().anyRequest().permitAll();
	}

	// configure(HttpSecurity http)方法中用于配置验证方式和资源的授权（什么角色可以访问什么资源）
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/","/index","/To_admin_login","main",
//
//
//
//
//
//						"/user_login","/toUserLogin","/userself","/userself1","/toRegister","/register_fail","/register","/register_succeed","/update_fail",
//						"/login_failed").permitAll() //这里表示首页不用登陆就可以访问
//
//
//
//
//				.antMatchers("/user/**").hasAnyRole("user","admin") //这里的角色名可以随便起，但是尽量有意义
////				.antMatchers("/admin/**").hasRole("admin")
//				.antMatchers("/sadmin/**").hasRole("sadmin") //这里表示发送/sadmin/**需要登陆且具备sadmin角色
//				.anyRequest().authenticated() //任何其他请求登录即可，不需要具备什么角色
//
//
//			.and() //可以通过调用and()方法回到HttpSecurity对象，继续调用它的其他方法
//				.formLogin()
//				     //这个方法用于指定自定义的登录页面，指定的不是页面名称，指定的是跳转到登录页面的请求的url
//					.loginPage("/toUserLogin") //自定义的登录页面是有要求的，要求具体参见login_page.html页面
//					.defaultSuccessUrl("/index")
//					.failureUrl("/login_failed") //如果用户名或密码不正确会发出的请求，最终导致跳转到一个页面
//			.and()
//				.logout()
//				.logoutSuccessUrl("/index")//退出成功访问的页面
//				.invalidateHttpSession(true)//清空session
//			.and()
//				.headers().frameOptions().disable()
//			.and()
//				.rememberMe() //启用记住密码功能
//				.rememberMeParameter("rememberMe") //指定实现记住密码功能的请求参数的名称
//				.rememberMeCookieName("rem") //记住密码是通过在客户端放一个Cookie实现的，可以指定Cookie的名称
//				.tokenValiditySeconds(7*24*60*60) //指定记住多久
//
//			.and()
//				.httpBasic()
//			.and()
//				//在项目中，可能会发送很多post请求，如果这里不禁用csrf()
//				//，也就是禁用对跨站请求伪造攻击防护，可能会产生一些问题
//				//至于如何在启用攻击防护的情况下正常发送post请求，可自行探索。
//				.csrf().disable()
//				.headers().frameOptions().sameOrigin();
//
//		// 也可以使用表单验证（表单验证另一种验证方式，跳转到一个带表单的页面来输入用户名和密码）
//		//http.formLogin();
//		// 可以使用基本验证（基本验证是一种验证方式，弹出一个对话框来用于输入用户名和密码）
//		//http.httpBasic();
//	}


}
