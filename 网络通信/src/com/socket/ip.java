package com.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ip {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        String localName = ip.getHostName();    //获取本地主机名
        String localIp = ip.getHostAddress();
        System.out.println("localName: "+localName+" localIp: "+localIp);
    }
}
