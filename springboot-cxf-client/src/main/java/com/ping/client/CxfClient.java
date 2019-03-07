package com.ping.client;

import com.ping.entity.User;
import com.ping.service.UserService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @author: zhangsp
 * @date: 2019/3/7 9:44
 * @copyright: @2019
 */

public class CxfClient {
    public static void main(String[] args) {
        client1();
    }

    /**
     *  代理类工厂
     */
    public static void client1() {
        try {
            // 接口地址
            String address = "http://localhost:8080/soap/user?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(UserService.class);
            // 创建一个代理接口实现
            UserService service = (UserService)jaxWsProxyFactoryBean.create();

            String  userName = service.getName(10002L);
            System.out.println("返回结果   userName :" + userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态调用
     */
    public static void client2() {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/soap/user?wsdl");

        Object[] objects;
        try {
            objects = client.invoke("getName", 10002L);

            //输出调用结果
            System.out.println(objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
