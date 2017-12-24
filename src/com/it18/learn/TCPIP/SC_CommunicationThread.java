package com.it18.learn.TCPIP;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Think on 2017/12/23.
 * 多线程通信server client
 */
public class SC_CommunicationThread extends Thread
{
    //socket
    private Socket socket;
    private  String clientinfo;
    public SC_CommunicationThread(Socket socket)
    {
        super();
        this.socket=socket;
        clientinfo=getclientinfo();
    }
    public void run()
    {
        System.out.println("有链接了");

        try {
            //接受数据
            InputStream is= socket.getInputStream();//输入流，读取客户端内容
            OutputStream os=socket.getOutputStream();//输出流，回传给客户端
            InputStreamReader reader= new InputStreamReader(is);
            OutputStreamWriter write= new OutputStreamWriter(os);
            char[] buf=new char[1024];
            int len=0;
            while ((len=reader.read(buf))!=-1)
            {
                String msg=new String(buf,0,len);

                System.out.println("["+clientinfo+"]" +msg);
                write.write("[from server]"+msg);
                write.flush();

            }
        } catch (IOException e) {
            System.out.println(clientinfo+"断开");
//            e.printStackTrace();
        }

    }

    private  String getclientinfo(){
      try {
          InetSocketAddress addr = (InetSocketAddress) socket.getRemoteSocketAddress();

          return addr.getHostName() + ":" + addr.getPort();
      }
      catch(Exception e)
      {e.printStackTrace();

      }
      return null;
    }

}
