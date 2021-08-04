package com.it.xiao.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author: xiaoqiang
 * @Description:
 * @Date: 2021/7/30
 * @Version: 1.0
 */

@ConfigurationProperties(prefix = "elasticjob.zookeeper")
public class ZookeeperAutoProperties {

    String serverList; //zookeeper服务器地址
    String namespace;  //命名空间

    public String getServerList() {
        return serverList;
    }

    public void setServerList(String serverList) {
        this.serverList = serverList;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
