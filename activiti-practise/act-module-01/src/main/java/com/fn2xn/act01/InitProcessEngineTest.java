package com.fn2xn.act01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @Author lzg
 * @date 2020/11/16 11:24
 */
public class InitProcessEngineTest {

    private static final Logger logger = LoggerFactory.getLogger(InitProcessEngineTest.class);
    /**
     * 建表方式一
     */
    @Test
    public void initMode1Test(){
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml")
                .buildProcessEngine();
        logger.info("方式一=============={}", processEngine);
    }
    /**
     * 建表方式二
     */
    @Test
    public void initMode2Test(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setJdbcUrl("jdbc:mysql://127.0.0.1:3306/act-test?characterEncoding=UTF-8&useUnicode=true&useSSL=false&tinyInt1isBit=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&nullCatalogMeansCurrent=true")
                .setJdbcUsername("root")
                .setJdbcPassword("root")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
                .buildProcessEngine();
        logger.info("方式二=============={}", processEngine);
    }
    /**
     * 建表方式三
     */
    @Test
    public void initMode3Test(){
        // 默认去寻找根目录下的 activiti.cfg.xml文件
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        logger.info("方式三=============={}", processEngine);
    }

}
