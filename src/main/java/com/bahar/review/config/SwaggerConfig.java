package com.bahar.review.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
//@Import(SpringDataRestConfiguration.class) //??
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)

                .groupName("public-api")
                .apiInfo(apiInfo())
                .select()
                .paths(postPaths())
                .build();

//                        .select()
//                .apis(RequestHandlerSelectors.any())
//                .build().pathMapping("/")
//                .apiInfo(metaData());

        /*
        .groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
         */
    }


    private Predicate<String> postPaths() {
		return or(regex("/api/product.*"), regex("/api/user.*")
                , regex("/bahar/api/product.*"));
	}

	private ApiInfo apiInfo() {

        Contact contact = new Contact("bahar-saremi", "https://github.com/akhsa234",
                "saremi.bah2000@gmail.com" + "mygithub");

		return new ApiInfoBuilder().title("swagger features for Review ApI")
				.description("example of swagger features with spring-boot")
				.termsOfServiceUrl("http://javainuse.com")
				.contact(contact).license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0").version("1.0").build();
	}


//    private Predicate<String> postPaths() {
//
//    }


//    private ApiInfo metaData() {
//
//        Contact contact = new Contact("bahar-saremi", "https://github.com/akhsa234",
//                "saremi.bah2000@gmail.com" + "mygithub");
//
//        return new ApiInfo(
//                "swagger features for Review ApI",
//                "    example of swagger features with spring-boot",
//                "1.0",
//                "Terms of Service",
//                contact,
//                "Apache License Version 2.0",
//                "https://www.apache.org/licenses/LICENSE-2.0",
//                new ArrayList<>());
//    }

    @Configuration
    public class CorsConfiguration implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS");
        }
    }
}
