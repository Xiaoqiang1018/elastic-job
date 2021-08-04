package com.it.xiao.elasticjob.config;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobTypeConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * @Author: xiaoqiang
 * @Description:
 * @Date: 2021/7/29
 * @Version: 1.0
 */
public class JobConfig {

    public static void main(String[] args) {

        //配置zookeeper
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration("127.0.0.1:2181", "elestic-job5");
        CoordinatorRegistryCenter coordinatorRegistryCenter= new ZookeeperRegistryCenter(zookeeperConfiguration);
        coordinatorRegistryCenter.init();

        //配置定时任务
        //shardingTotalCount 1 表示当前任务不进行分片（分片：那么多个实例会同时执行）
        JobCoreConfiguration elseticJobDemo1 = JobCoreConfiguration.newBuilder("elseticJobDemo1", "*/2 * * * * ?", 1).build();
        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(elseticJobDemo1, MySimpleJob.class.getName());
        // overwrite 表示是否将zookeeper,job等信息写到zookeeper中
        JobScheduler jobScheduler = new JobScheduler(coordinatorRegistryCenter, LiteJobConfiguration.newBuilder(simpleJobConfiguration).overwrite(true).build());
        jobScheduler.init();
    }
}
