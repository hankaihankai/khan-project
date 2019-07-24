package com.khan.auth.config;

import com.khan.auth.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * 认证服务器
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public TokenStore tokenStore() {
        //使用内存的tokenStore
        return new InMemoryTokenStore();
    }

    @Bean
    public ClientDetailsService clientDetails() {
        return new InMemoryClientDetailsService();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("hankai").secret(passwordEncoder.encode("123456")).authorizedGrantTypes("password").scopes("user")
                .and()
                .withClient("hank").secret(passwordEncoder.encode("123456")).authorizedGrantTypes("authorization_code")
                .redirectUris("http://www.baidu.com").scopes("user")
        ;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.passwordEncoder(passwordEncoder)
        ;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.userDetailsService(userServiceImpl)
                .tokenStore(tokenStore())
                .authenticationManager(authenticationManager)
                .setClientDetailsService(clientDetails());
        ;
    }
}
