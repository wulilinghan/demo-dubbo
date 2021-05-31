package top.b0x0.mydubbo.myprovide;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("top.b0x0.mydubbo.mycommonmapper")
@EnableAsync
public class MyProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyProvideApplication.class, args);
    }

}
