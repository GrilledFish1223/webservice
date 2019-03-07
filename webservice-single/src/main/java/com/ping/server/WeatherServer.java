package main.java.com.ping.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: zhangsp
 * @date: 2019/3/5 10:51
 * @copyright: @2019
 */

public class WeatherServer {
    public static void main(String[] args) throws IOException {
        //创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket();

        while (true) {
            //等待用户连接
            final Socket socket = serverSocket.accept();

            Runnable runnable = () -> {
                try {
                    //使用输入流接收用户发送的请求
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    String cityName = dis.readUTF();
                    System.out.println("接收到客户端发送的请求" + cityName);

                    Thread.sleep(1000);

                    //根据城市名称查询天气
                    String result = "今天天气很热";
                    System.out.println("返回天气信息：" + result);

                    //返回查询结果
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF(result);

                    //关闭流
                    dis.close();
                    dos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

            //start
            new Thread(runnable).start();
        }
    }
}
