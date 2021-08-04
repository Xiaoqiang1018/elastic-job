package com.it.xiao.elasticjob.config;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @Author: xiaoqiang
 * @Description:
 * @Date: 2021/7/29
 * @Version: 1.0
 */
public class MySimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("当前分片项： "+shardingContext.getShardingItem()+" 分片总数"+ shardingContext.getShardingTotalCount());
    }
}
