package com.it.xiao.autoconfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: xiaoqiang
 * @Description:
 * @Date: 2021/7/30
 * @Version: 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableSimpleElasticJob {

    //定时任务名称
    String jobname() default "";
    String cron() default "";
    //分片数量
    int sharddingCount() default 1;
    //zookeeper配置是否允许覆盖
    boolean overwrire() default false;

}
