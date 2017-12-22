package com.it18.learn.TCPIP;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Think on 2017/12/22.
 */
public class myclient {


@Test
    public void send() throws IOException {
        Socket s=new Socket("localhost",8888);
        //获得输出流
        OutputStream os=s.getOutputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while((line= reader.readLine())!=null)
                {
                    os.write(line.getBytes());

                }

    }
}
