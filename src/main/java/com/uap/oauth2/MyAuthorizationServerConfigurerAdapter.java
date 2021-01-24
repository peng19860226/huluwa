package com.uap.oauth2;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import com.uap.dao.UserDao;
import com.uap.model.UserEntity;

@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfigurerAdapter extends AuthorizationServerConfigurerAdapter {

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		/*设置签名*/
		accessTokenConverter.setSigningKey("smallsnail");
		return accessTokenConverter;
	}
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private RedisConnectionFactory redisConnection;

	@Autowired
    private DataSource dataSource;
	@Autowired
    UserDao userDao;
	
	@Bean 
    public ClientDetailsService myClientDetailsService() {
		JdbcClientDetailsService jdbcClient = new JdbcClientDetailsService(dataSource);
        return jdbcClient;
    }
	//用来配置令牌端点(Token Endpoint)的安全约束.
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		super.configure(security);
	}
    @Bean
    public TokenEnhancer tokenEnhancer(){
        return new TokenEnhancer() {
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                if (accessToken instanceof DefaultOAuth2AccessToken){
                    DefaultOAuth2AccessToken token= (DefaultOAuth2AccessToken) accessToken;
                    Map<String, Object> additionalInformation = new LinkedHashMap<String, Object>();
                    User user = (User)authentication.getPrincipal();
                    UserEntity userEntity = userDao.getUserEntityById(Integer.valueOf(user.getUsername()));
//                    additionalInformation.put("username",user.getUsername());
                    userEntity.setPassword(null);
                    additionalInformation.put("user_info", userEntity);
                    token.setAdditionalInformation(additionalInformation);
                }
                return accessToken;
            }
        };
    }
	//用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		/*jwt方式+redis存储token*/
		endpoints.accessTokenConverter(jwtAccessTokenConverter());
//		endpoints.tokenEnhancer(tokenEnhancer()).authenticationManager(authenticationManager).tokenStore(new RedisTokenStore(redisConnection));
		
		endpoints.tokenEnhancer(tokenEnhancer()).authenticationManager(authenticationManager).tokenStore(new MyRedisTokenStoreService(redisConnection,myClientDetailsService()));
		/*配置端点URL链接，它有两个参数：
		第一个参数：String 类型的，这个端点URL的默认链接。
		第二个参数：String 类型的，你要进行替代的URL链接。
		以上的参数都将以 "/" 字符为开始的字符串，框架的默认URL链接如下列表，可以作为这个 pathMapping() 方法的第一个参数：
		/oauth/authorize：授权端点。
		/oauth/token：令牌端点。
		/oauth/confirm_access：用户确认授权提交端点。
		/oauth/error：授权服务错误信息端点。
		/oauth/check_token：用于资源服务访问的令牌解析端点。
		/oauth/token_key：提供公有密匙的端点，如果你使用JWT令牌的话。*/
		//		endpoints.pathMapping(defaultPath, customPath)
		/*普通*/

	        // 配置TokenServices参数
//	        DefaultTokenServices tokenServices = new DefaultTokenServices();
//	        tokenServices.setTokenStore(endpoints.getTokenStore());
//	        tokenServices.setSupportRefreshToken(true);
//	        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
//	        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
////	        tokenServices.setAccessTokenValiditySeconds( (int) TimeUnit.DAYS.toSeconds(30)); // 30天
//	        tokenServices.setAccessTokenValiditySeconds(20); // 20秒
//	        tokenServices.setRefreshTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1));
//		    endpoints.tokenServices(tokenServices);
		     

	}
	//用来配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(myClientDetailsService());
	}


}
