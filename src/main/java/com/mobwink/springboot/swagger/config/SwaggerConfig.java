package com.mobwink.springboot.swagger.config;

import com.fasterxml.classmate.TypeResolver;

import java.lang.reflect.WildcardType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Autowired
	private TypeResolver typeResolver;
	
	@Value("${app.version}")
	private String appVersion;
	
	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors
						.basePackage("com.mobwink.springboot.swagger.controller"))
					.paths(PathSelectors.regex("/api/.*"))
					.build()
				.pathMapping("/")
				.genericModelSubstitutes(ResponseEntity.class)
				.alternateTypeRules(
						AlternateTypeRules.newRule(typeResolver.resolve(DeferredResult.class,
												   typeResolver.resolve(ResponseEntity.class,WildcardType.class)), 
												   typeResolver.resolve(WildcardType.class)))
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {

		return new ApiInfo("API SpringBoot com Swagger",
						   "API para estudo da implementação do springboot com swagger",
						   appVersion, 
						   "urn:tos", 
						   new Contact("Maicon Keller", "http://www.mobwink.com", "maicon@mobwink.com"), 
						   "API License",
						   "http://www.api-license-url.com");
	}

}
