package top.sharehome.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

/**
 * 基础数据模块
 *
 * @author AntonyCheng
 */
@SpringBootApplication
@MapperScan(basePackages = {"top.sharehome.base.mapper"})
public class AntonyBaseApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AntonyBaseApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
        System.out.println("(♥◠‿◠)ﾉﾞ  基础数据模块启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
