package com.khan.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * 认证服务器
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 认证密码方式
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.passwordEncoder(passwordEncoder);
    }

    /**
     * 配置用户
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //client Id
                .withClient("api")
                .authorizedGrantTypes("authorization_code", "password")
                .authorities("api")
                .scopes("api")
                .resourceIds("1")
                .redirectUris("http://www.baidu.com")
                .secret(passwordEncoder.encode("secret"))
                .accessTokenValiditySeconds(3000)//授权码存活时间

                .and()
                .withClient("user")
                .authorizedGrantTypes("authorization_code", "password")
                .authorities("user")
                .scopes("read", "write")
                .resourceIds("2")
                .redirectUris("http://www.baidu.com")
                .accessTokenValiditySeconds(3000)
                .secret(passwordEncoder.encode("secret"));
    }
}
