package com.webapp.webhome.common.config;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig implements WebMvcConfigurer {

	private String basePackage = "com.webapp.webhome";

	TypeResolver typeResolver = new TypeResolver();

	@Bean
	public Docket api() {
		final ApiInfo apiInfo = new ApiInfoBuilder()
				.title("Spring Boot REST API")
				.version("1.0.0")
				.description("회원등록/로그인 API")
				.build();
		return new Docket(DocumentationType.OAS_30)
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(Pageable.class),typeResolver.resolve(Page.class)))
				.apiInfo(apiInfo)
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				.paths(PathSelectors.any())
				.build()
				;
	}
	private ApiKey apiKey() {
		return new ApiKey("JWT", "jwt", "header");
	}
	private SecurityContext securityContext() {
		return springfox
				.documentation
				.spi.service
				.contexts
				.SecurityContext
				.builder()
				.securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}

	@Getter @Setter
	@ApiModel
	static class Page {
		@ApiModelProperty(value = "페이지 번호(0..N)")
		private Integer page;

		@ApiModelProperty(value = "페이지 크기", allowableValues="range[0, 100]")
		private Integer size;

		@ApiModelProperty(value = "정렬(사용법: 컬럼명,ASC|DESC)")
		private List<String> sort;
	}
}
