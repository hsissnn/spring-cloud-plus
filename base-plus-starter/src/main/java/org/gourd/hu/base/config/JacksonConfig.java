package org.gourd.hu.base.config;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;

/**
 * Jackson配置
 *
 * @author gourd.hu
 */
public class JacksonConfig {
 
	/**
	 * Jackson全局转化long类型为String，解决jackson序列化时long类型缺失精度问题
	 * @return Jackson2ObjectMapperBuilderCustomizer 注入的对象
	 */
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
		Jackson2ObjectMapperBuilderCustomizer customizer = jacksonObjectMapperBuilder -> {
			jacksonObjectMapperBuilder.serializerByType(BigInteger.class, ToStringSerializer.instance);
			jacksonObjectMapperBuilder.serializerByType(Long.class, ToStringSerializer.instance);
			jacksonObjectMapperBuilder.serializerByType(Long.TYPE, ToStringSerializer.instance);
		};
		return customizer;
	}
}