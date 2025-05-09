package com.qdu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@MapperScan用于启用对Mapper接口所在包的扫描，这样会自动发现Mapper，并进行注册
//可以指定一个包或多个包（以数组形式给出即可）


@ComponentScan(basePackages = {"com.qdu.service"})
@MapperScan(basePackages = {"com.qdu.mapper"})
public class SpringConfig {

} 
