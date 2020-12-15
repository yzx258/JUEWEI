package com.rbgt.jw;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yiautos
 */
@Slf4j
@SpringBootApplication
public class JwApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwApplication.class, args);
        log.info("================ 绝味服务启动成功 ================");
    }

}
