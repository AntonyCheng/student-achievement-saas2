package top.sharehome.business;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

/**
 * 业务数据模块
 *
 * @author AntonyCheng
 */
@EnableDubbo
@SpringBootApplication
@MapperScan(basePackages = {"top.sharehome.business.mapper"})
public class AntonyBusinessApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AntonyBusinessApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
        System.out.println("(♥◠‿◠)ﾉﾞ  业务数据模块启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
