package main.java.com.ping.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author: zhangsp
 * @date: 2019/3/5 10:45
 * @copyright: @2019
 */

public class WeatherClient {
    public static void main(String[] args) throws IOException {
        //创建Socket对象
        Socket socket = new Socket("127.0.0.1", 56751);
        //发布
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("杭州");
        System.out.println("请求查询天气： 杭州");

        //接收返回结果使用输入流
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String result = dis.readUTF();
        System.out.println("北京的天气：" + result);

        //关闭流
        dis.close();
        dos.close();
    }
}
