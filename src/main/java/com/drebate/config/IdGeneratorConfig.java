package com.drebate.config;

import com.drebate.service.component.IdGenerator;
import com.drebate.service.component.IdGeneratorFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenyongqdu@foxmail.com
 */
@Configuration
public class IdGeneratorConfig {

    private @Value("${zookeeper.servers}") String zkServers;

    @Bean
    public IdGenerator idGenerator(IdGeneratorFactoryBean idGeneratorFactory) {
        try {
            return idGeneratorFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Id生成器构造出错");
    }

    @Bean
    public IdGeneratorFactoryBean idGeneratorFactory() {
        IdGeneratorFactoryBean factoryBean = new IdGeneratorFactoryBean();
        factoryBean.setZkAddress(zkServers);
        return factoryBean;
    }
}
