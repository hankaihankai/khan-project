package com.khan.tool.generator.mybatisplus.config;

import java.util.List;

/**
 * 生成配置
 */
public class MybatisGenerateConfig {

    /**
     * 生成人姓名
     */
    private String author;
    /**
     * 项目根路径
     */
    private String projectDirPath;
    /**
     * 父级包名 ru com.test.user
     */
    private String parentPackage;
    /**
     * 模块
     */
    private String model;

    /**
     * 数据库url
     */
    private String url;
    /**
     * 数据库驱动
     */
    private String driverName;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 表名
     */
    private List<String> tables;
    /**
     * 表前缀  生成实体会去掉前缀
     */
    private List<String> tablePrefix;

    /**
     * 字段前缀  生成实体会去掉前缀
     */
    private List<String> fieldPrefix;

    /**
     * 是否开启lombok
     */
    private Boolean lombok;
    /**
     * 继承的父类实体路径    如    com.test.BaseEntity
     */
    private String superEntityClass;
    /**
     * 父类实体(BaseEntity) 的字段   如  id   create_time
     */
    private List<String> superEntityColumns;

    /**
     * 继承的父类controller路径    如    com.test.BaseController
     */
    private String superControllerClass;

    public String getProjectDirPath() {
        return projectDirPath;
    }

    public void setProjectDirPath(String projectDirPath) {
        this.projectDirPath = projectDirPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getParentPackage() {
        return parentPackage;
    }

    public void setParentPackage(String parentPackage) {
        this.parentPackage = parentPackage;
    }

    public List<String> getTables() {
        return tables;
    }

    public void setTables(List<String> tables) {
        this.tables = tables;
    }

    public List<String> getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(List<String> tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public List<String> getFieldPrefix() {
        return fieldPrefix;
    }

    public void setFieldPrefix(List<String> fieldPrefix) {
        this.fieldPrefix = fieldPrefix;
    }

    public Boolean getLombok() {
        return lombok;
    }

    public void setLombok(Boolean lombok) {
        this.lombok = lombok;
    }

    public String getSuperEntityClass() {
        return superEntityClass;
    }

    public void setSuperEntityClass(String superEntityClass) {
        this.superEntityClass = superEntityClass;
    }

    public String getSuperControllerClass() {
        return superControllerClass;
    }

    public void setSuperControllerClass(String superControllerClass) {
        this.superControllerClass = superControllerClass;
    }

    public List<String> getSuperEntityColumns() {
        return superEntityColumns;
    }

    public void setSuperEntityColumns(List<String> superEntityColumns) {
        this.superEntityColumns = superEntityColumns;
    }
}
