package com.it18.learn.TCPIP;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Think on 2017/12/22.
 */




public class SC_myclient {
    public static void main(String[] args) {
    clientsend cs=new clientsend();
        try {
            cs.send();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


class clientsend{

    public void send() throws IOException {
        Socket s=new Socket("localhost",8888);
        //获得输出流
        OutputStream os=s.getOutputStream();
        InputStream is=s.getInputStream();
//        for(int i=0;i<1000;i++)
//        {




            BufferedReader reader=new BufferedReader( new InputStreamReader(System.in)); //new StringReader("A"+i)
            String line=null;
            byte[] buf=new byte[1024];
            int len=-1;
            while((line= reader.readLine())!=null)
            {
                os.write(line.getBytes());
                len=is.read(buf);
                System.out.println(new String(buf,0,len));

            }
        }

//    }

}