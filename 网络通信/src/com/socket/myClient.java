package com.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//import static com.socket.myServer.MY_SERVER_PORT;

public class myClient {
    public static void main(String[] args) {

        commWithServer();
    }

    private static void commWithServer() {
        try(
        Socket s =new Socket("localhost",55555);
        ){
            //System.out.println("客户端连接到"+s.getRemoteSocketAddress());
            myChat myChat=new myChat(s,"服务器端",null);
            myChat.chatting();
        }catch (UnknownHostException e){
            e.printStackTrace();;
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
