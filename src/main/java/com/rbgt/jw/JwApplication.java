package com.rbgt.jw;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yiautos
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.rbgt.jw"})
public class JwApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwApplication.class, args);
        log.info("================ 绝味服务启动成功 ================");
    }

}
