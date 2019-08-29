package com.wangzk.im.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Title: WebSocketConfig
 * @ProjectName: im
 * @PackageName: com.wangzk.im.config
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-27 09:56
 */
@Configuration
public class WebSocketConfig {

    /**
     * 注入ServerEndpointExporter，
     * 这个bean会自动注册使用了@ServerEndpoint注解声明的
     * Websocket endpoint
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
