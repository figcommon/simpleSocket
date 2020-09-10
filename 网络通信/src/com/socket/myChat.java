package com.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static com.socket.myServer.BYE;
import static com.socket.myServer.MY_COMM_CHARSET;

public class myChat {
    private Socket s;
    private String from;
    private String greating;

    public myChat(Socket s, String from, String greating) {
        this.s = s;
        this.from = from;
        this.greating = greating;
    }
    public void chatting(){
        Scanner in=new Scanner(System.in);
        try(
                BufferedReader br =new BufferedReader(
                        new InputStreamReader(s.getInputStream(),MY_COMM_CHARSET)
                );
                PrintWriter pw =new PrintWriter(
                        new OutputStreamWriter(s.getOutputStream(),MY_COMM_CHARSET)
                );
        ){
            if(greating!=null){
            pw.println(greating);
            pw.flush();}
            while (true){
                String line =br.readLine();

                if (line.equalsIgnoreCase(BYE)){
                    pw.println(BYE);
                    break;
                }else{
                    System.out.println(from+":"+line);
                    break;

                    //String myword =in.nextLine();
                    //pw.println(myword);
                    //pw.flush();
                }
            }
//            System.out.println("和客户端建立连接成功"+s.getRemoteSocketAddress());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
