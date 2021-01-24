package com.uap.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class MyResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()
//		.antMatchers("/oauth/**").permitAll()
		.antMatchers("/public/**").permitAll()
		.antMatchers("/authentication/github","/authentication/qq").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/exit").permitAll()
		.antMatchers("/**/*.jpg","/**/*.png","/**/*.jpeg").permitAll()
		 //以 "/admin/" 开头的URL只能让拥有 "ROLE_ADMIN"角色的用户访问。
        //请注意我们使用 hasRole 方法，没有使用 "ROLE_" 前缀。 
		.antMatchers("/users/**","/menus/**","/roles/**","/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated();

	}

}
