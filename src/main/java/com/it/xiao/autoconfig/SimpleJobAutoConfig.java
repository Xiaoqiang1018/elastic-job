package com.it.xiao.autoconfig;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobTypeConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;

@Configuration
@ConditionalOnBean(CoordinatorRegistryCenter.class) //表示发现这个类的实例就会加载
@AutoConfigureAfter(ZookeeperAutoConfiguration.class) //表示加载完，
public class SimpleJobAutoConfig {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private CoordinatorRegistryCenter coordinatorRegistryCenter;

    @PostConstruct
    public void initSimpleJob() {
        //获取使用到EnableSimpleElasticJob 注解的bean
        Map<String, Object> map = context.getBeansWithAnnotation(EnableSimpleElasticJob.class);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            //判断是否实现SimpleJob
            Class<?>[] interfaces = entry.getValue().getClass().getInterfaces();
            for (Class<?> anInterface : interfaces) {
                if (anInterface == SimpleJob.class) {
                    //获取到注解里的属性值
                    EnableSimpleElasticJob annotation = entry.getValue().getClass().getAnnotation(EnableSimpleElasticJob.class);
                    String jobname = annotation.jobname();
                    String cron = annotation.cron();
                    int i = annotation.sharddingCount();
                    boolean overwrire = annotation.overwrire();

                    //配置job

                    JobCoreConfiguration elseticJobDemo1 = JobCoreConfiguration.newBuilder(jobname, cron, i).build();
                    JobTypeConfiguration jobType = new SimpleJobConfiguration(elseticJobDemo1, entry.getValue().getClass().getName());

                    LiteJobConfiguration build = LiteJobConfiguration.newBuilder(jobType).overwrite(true).build();

                    new JobScheduler(coordinatorRegistryCenter, build).init();
                }
            }
        }

    }
}
