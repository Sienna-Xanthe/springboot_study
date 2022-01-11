package com.kuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2  //开启swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }


    //配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){


        //当前情况是只能在dev测试环境下访问8082端口才能查看swagger

        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");

        //获取项目环境：
        //通过 environment.acceptsProfiles 监听判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("pxy")
                .enable(flag)//enable是否启动Swagger，如果为false，则Swagger不能在浏览器中访问
                .select()
                //RequestHandlerSelectors  配置要扫描的接口的方式
                //basePackage  指定要扫描的包
                //any  扫描全部
                //none  不扫描
                //withClassAnnotation  扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation  扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.kuang.controller"))
                //paths()  过滤什么路径
//                .paths(PathSelectors.ant("/kuang/**"))
                .build()
                ;
    }

    //配置Swagger 信息=apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("作者名字", "作者官网链接", "3043015301@qq.com");
        return new ApiInfo(
                "pxy的SwaggerAPI文档",
                "这是api的简介",
                "1.0",
                "https://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}
