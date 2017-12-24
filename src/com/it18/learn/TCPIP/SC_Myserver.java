package com.it18.learn.TCPIP;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Think on 2017/12/22.
 */
public class SC_Myserver {
    @Test
    public  void start() throws IOException {
        ServerSocket ss=new ServerSocket(8888);
        while (true)
        {
           Socket s=ss.accept();//接受客户端请求
           new SC_CommunicationThread(s).start();



        }


    }
}
