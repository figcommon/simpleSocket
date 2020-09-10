package com.socket;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class myServer {
    public static final int MY_SERVER_PORT =55555;
    public static final Charset MY_COMM_CHARSET= StandardCharsets.UTF_8;
    public static final String BYE ="bye";

    public static void main(String[] args) throws IOException {
        commWithClient();
    }

    private static void commWithClient() throws IOException {
        ServerSocket ss=new ServerSocket(MY_SERVER_PORT);

        while (true){try(
                Socket s=ss.accept();
        ){
            myChat myChat=new myChat(s,"客户端","你已经连接上server");
            myChat.chatting();
        }}

//        try(
//                ServerSocket ss=new ServerSocket(MY_SERVER_PORT);
//                Socket s=ss.accept();
//                BufferedReader br =new BufferedReader(
//                        new InputStreamReader(s.getInputStream(),MY_COMM_CHARSET)
//                );
//                PrintWriter pw =new PrintWriter(
//                        new OutputStreamWriter(s.getOutputStream(),MY_COMM_CHARSET)
//                );
//            ){
//                pw.println("你好 客户端，我们已经连接上了 可以chat了");
//                pw.flush();
//                while (true){
//                    String line =br.readLine();
//                    if (line.equalsIgnoreCase(BYE)){
//                        pw.println(BYE);
//                        break;
//                    }else{
//                        System.out.println("Server:"+line);
//                        String myword =in.nextLine();
//                        pw.println(myword);
//                    }
//                }
////            System.out.println("和客户端建立连接成功"+s.getRemoteSocketAddress());
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
