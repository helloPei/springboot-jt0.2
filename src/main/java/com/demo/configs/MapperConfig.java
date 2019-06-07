package com.demo.configs;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * 通用mapper配置类
 */
@Configuration
public class MapperConfig {

	/**
	 * 使用通用Mapper之前需要初始化的一些信息 使用通用Mapper插件时请勿使用热加载,否则报错,插件作者后续应该会修复
	 */
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.demo.mapper");// 普通mapper的位置
		
		Properties properties = new Properties();
		properties.setProperty("mappers", BaseMapper.class.getName());// 通用mapper的全名
		properties.setProperty("notEmpty", "false");
		properties.setProperty("IDENTITY", "MYSQL");// 配置数据库方言
		mapperScannerConfigurer.setProperties(properties);
		return mapperScannerConfigurer;
	}

}