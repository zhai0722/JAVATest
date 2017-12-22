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
public class Myserver {
    @Test
    public  void start() throws IOException {
        ServerSocket ss=new ServerSocket(8888);
        while (true)
        {
            Socket s=ss.accept();
            System.out.println("有链接了");
            InputStream is=s.getInputStream();
            InputStreamReader reader= new InputStreamReader(is);
            char[] buf=new char[1024];
            int len=0;
            while ((len=reader.read(buf))!=-1)
            {
                System.out.println(new String(buf,0,len));

            }


        }


    }
}
