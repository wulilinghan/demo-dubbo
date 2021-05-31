package top.b0x0.mudubbo.myconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * 只在dev和test,native,local环境下开启
 *
 * @author TANG
 */
@Configuration
//@EnableSwagger2
//@EnableSwaggerBootstrapUI
//@EnableKnife4j
@EnableSwagger2WebMvc
@Import(BeanValidatorPluginsConfiguration.class)
@Profile({"dev", "test", "native", "local"})
public class SwaggerConfig {

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                .groupName("springboot-dubbo-nacos-demo")
                .select()
                // 扫描controller路径
                .apis(RequestHandlerSelectors.basePackage("top.b0x0.mudubbo.myconsumer.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * name:开发者姓名
     * url:开发者网址
     * email:开发者邮箱
     *
     * @return /
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("sdnd接口文档")
                // 文档接口的描述
                .description("springboot集成dubbo, 使用nacos作为注册中心的demo")
                .contact(new Contact("TANG", "tanglinghan.github.io", "1902325071@qq.com"))
//                .termsOfServiceUrl("http://127.0.0.1:8081/doc.html")
                // 版本号
                .version("1.0.0")
                .build();
    }

}