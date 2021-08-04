package com.it.xiao.autoconfig;

import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xiaoqiang
 * @Description:
 * @Date: 2021/7/30
 * @Version: 1.0
 */
@Configuration
@EnableConfigurationProperties(ZookeeperAutoProperties.class)
//表示application.yml中配置了elasticjob.zookeeper.serverList 那么就会加载该配置类
@ConditionalOnProperty("elasticjob.zookeeper.serverList")
public class ZookeeperAutoConfiguration {

    @Autowired
    private ZookeeperAutoProperties properties;

    @Bean
    public CoordinatorRegistryCenter zkCenter(){
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(properties.getServerList(), properties.getNamespace());
        zookeeperConfiguration.setConnectionTimeoutMilliseconds(30000);
        ZookeeperRegistryCenter zookeeperRegistryCenter = new ZookeeperRegistryCenter(zookeeperConfiguration);
        zookeeperRegistryCenter.init();
        return zookeeperRegistryCenter;
    }

}
