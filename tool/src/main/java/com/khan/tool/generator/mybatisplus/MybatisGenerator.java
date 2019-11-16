package com.khan.tool.generator.mybatisplus;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.google.common.collect.Lists;
import com.khan.tool.generator.mybatisplus.config.MybatisGenerateConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成
 */
public class MybatisGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static void main(String[] args) {
		String url = "jdbc:mysql://10.211.55.3:3306/khan?useUnicode=true&useSSL=false&characterEncoding=utf8";
		String driverName = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "123456";
		MybatisGenerateConfig config = new MybatisGenerateConfig();
		config.setAuthor("hankai");
		config.setProjectDirPath(System.getProperty("user.dir") + "/tool");
		config.setModel("utils");
		config.setParentPackage("com.khan.tool");
		config.setUrl(url);
		config.setDriverName(driverName);
		config.setUsername(username);
		config.setPassword(password);
		config.setTables(Lists.newArrayList("users"));
//		config.setTablePrefix(Lists.newArrayList("tb_"));
//		config.setFieldPrefix(Lists.newArrayList("sys_"));
		config.setLombok(true);
//		config.setSuperEntityClass("com.kan.tool.entity.BaseEntity");
//		config.setSuperEntityColumns(Lists.newArrayList("id", "create_time"));
//		config.setSuperControllerClass("com.kan.tool.controller.BaseController");
        generate(config);
    }

    public static void generate(MybatisGenerateConfig config) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(config.getProjectDirPath() + "/src/main/java");
        gc.setAuthor(config.getAuthor());
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(config.getUrl());
        // dsc.setSchemaName("public");
        dsc.setDriverName(config.getDriverName());
        dsc.setUsername(config.getUsername());
        dsc.setPassword(config.getPassword());
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(config.getModel());
        pc.setParent(config.getParentPackage());
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return config.getProjectDirPath() + "/src/main/resources/mapper/" + config.getModel() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        if (!CollectionUtil.isEmpty(config.getTablePrefix())) {
            Object[] objects = config.getTablePrefix().toArray();
            String[] tablePrefix = new String[objects.length];
            for (int i = 0; i < objects.length; i++) {
                tablePrefix[i] = objects[i].toString();
            }
            strategy.setTablePrefix(tablePrefix);
        }

        if (!CollectionUtil.isEmpty(config.getFieldPrefix())) {
            Object[] objects = config.getFieldPrefix().toArray();
            String[] fieldPrefix = new String[objects.length];
            for (int i = 0; i < objects.length; i++) {
                fieldPrefix[i] = objects[i].toString();
            }
            strategy.setFieldPrefix(fieldPrefix);
        }


        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        if (!StrUtil.isEmpty(config.getSuperEntityClass())) {
			strategy.setSuperEntityClass(config.getSuperEntityClass());
			if (!CollectionUtil.isEmpty(config.getSuperEntityColumns())) {
				Object[] objects = config.getSuperEntityColumns().toArray();
				String[] superEntityColumns = new String[objects.length];
				for (int i = 0; i < objects.length; i++) {
					superEntityColumns[i] = objects[i].toString();
				}
				strategy.setSuperEntityColumns(superEntityColumns);
			}
		}
        strategy.setEntityLombokModel(config.getLombok());
        strategy.setRestControllerStyle(true);
        if (!StrUtil.isEmpty(config.getSuperControllerClass())) {
			strategy.setSuperControllerClass(config.getSuperControllerClass());
		}

        Object[] objects = config.getTables().toArray();
        String[] tables = new String[objects.length];
        for (int i = 0; i < objects.length; i++) {
            tables[i] = objects[i].toString();
        }
        strategy.setInclude(tables);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
