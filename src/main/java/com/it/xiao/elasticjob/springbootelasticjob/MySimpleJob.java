package com.it.xiao.elasticjob.springbootelasticjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.it.xiao.autoconfig.EnableSimpleElasticJob;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @Author: xiaoqiang
 * @Description:
 * @Date: 2021/8/2
 * @Version: 1.0
 */
@Component
@EnableSimpleElasticJob(
        jobname = "MySimpleJob",
        cron = "*/2 * * * * ?",
        sharddingCount = 2,
        overwrire = true
)
public class MySimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("分片项 ：" + shardingContext.getShardingItem());


    }
}
