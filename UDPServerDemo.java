package com.louis.communication;

import java.io.IOException;
import java.net.*;

public class UDPServerDemo {
    public static void main(String[] args) {
        String info = "good good 学习,天天 up";
        byte[] bytes = info.getBytes();
        try {
            //封装一个数据包
            DatagramPacket dp = new DatagramPacket(bytes,
                    0,
                    bytes.length,
                    InetAddress.getByName("127.0.0.1"),
                    8000);
            //本程序的端口
            DatagramSocket socket = new DatagramSocket(9000);
            socket.send(dp);
            socket.close();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
