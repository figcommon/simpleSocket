package connect;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) throws IOException {
        int port = 9999;

        System.out.println("-----------服务器启动-----------");

        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        Reader reader = new InputStreamReader(socket.getInputStream());
        char chars[] = new char[1024];
        int len;
        StringBuilder builder = new StringBuilder();
        while ((len=reader.read(chars)) != -1) {
            builder.append(new String(chars, 0, len));
        }
        System.out.println("收到来自客户端的信息： " + builder);
        reader.close();
        socket.close();
        server.close();
    }

}