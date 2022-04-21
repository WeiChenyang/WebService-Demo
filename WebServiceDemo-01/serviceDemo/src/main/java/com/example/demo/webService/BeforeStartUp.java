package com.example.demo.webService;

import com.example.demo.webService.inter.WebServiceInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.xml.ws.Endpoint;

/**
 * 使用ApplicationContext事件机制来完成webService接口的自动发布。
 *
 * 使用ApplicationListener监听ContextRefreshedEvent事件。ContextRefreshedEvent就是在ApplicationContext被初始化（所有的bean被成功装载，后处理bean被检测或成功激活，所有的singleton bean被实例化，ApplicationConte容器已就绪可用）或刷新时，该事件被发布。
 *
 * 在webservice目录下新建一个类BeforeStartUp.java，实现ApplicationListene接口。
 *
 * 重写onApplicationEvent方法。在该方法中发布webService服务。使用javax.xml.ws.Endpoint的publish方法发布。该方法有两个参数，第一个是要使用的地址和传输/协议的URI。URI必须使用SOAP 1.1 / HTTP 绑定。第二个参数是webService的接口实现类。
 *
 * 该类也必须使用@Service，@Component或者@Configuration注解被spring管理，使其可以被自动装载。
 */
@Service
public class BeforeStartUp implements ApplicationListener<ContextRefreshedEvent> {

    private Log log = LogFactory.getLog(BeforeStartUp.class);

    private static String address = "http://localhost:8002/ws/hello";

    @Autowired
    private WebServiceInterface webServiceInterface;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Endpoint.publish(address,webServiceInterface);
        log.info("WebService 服务发布成功");
        log.info("wsdl地址:"+address+"?wsdl");
    }
}
