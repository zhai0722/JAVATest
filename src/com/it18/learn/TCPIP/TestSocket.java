package com.it18.learn.TCPIP;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

/**
 * Created by Think on 2017/12/22.
 * 端口0-65535
 */
@Test
public class TestSocket {
    public void test1() throws IOException {
        byte[] addr=new byte[]{(byte) 192,(byte)168,0,105};//绑定IP
        InetAddress iaddr=InetAddress.getByAddress(addr);//inetaddress没有端口只有IP ss.bind有端口
        ServerSocket ss=new ServerSocket(8888,50,iaddr);//去掉50,iaddr是统配
        ss.accept();
        System.out.println("over");

    }
@Test
    public void testserversocket() throws IOException {
        byte[] addr=new byte[]{(byte) 192,(byte)168,0,105};//绑定IP
        byte[] addr2=new byte[]{(byte) 192,(byte)168,(byte)159,1};//绑定IP
        //创建serversocket对象
        ServerSocket ss=new ServerSocket();
        InetSocketAddress adr1=new InetSocketAddress(InetAddress.getByAddress(addr),8888);
        ss.bind(adr1);
//        InetSocketAddress adr2=new InetSocketAddress(InetAddress.getByAddress(addr2),8888);
//        ss.bind(adr2);adr2
        //接受请求
    while (true) {
        Socket s = ss.accept();
        //本地地址
        InetSocketAddress localaddr = (InetSocketAddress) s.getLocalSocketAddress();
        System.out.println("local=" + localaddr.getHostName() + ":" + localaddr.getPort());
        //远程地址
        InetSocketAddress remoteaddr = (InetSocketAddress)s.getRemoteSocketAddress();
        System.out.println("remote"+remoteaddr.getHostName()+":"+remoteaddr.getPort());
    }

    }

    /*SERVERsocket 简单*/
    public  void testserversocked2(){
        try {
            ServerSocket ss= new ServerSocket(8888);
            while (true){
                Socket s=ss.accept();
                InetSocketAddress addr= (InetSocketAddress) s.getRemoteSocketAddress();
                int port = addr.getPort();
                String host= addr.getHostString();
                System.out.println(host+":"+port);
                //拿到输入流
                InputStream is=s.getInputStream();
                byte[] buf=new byte[1024];
                int len=0;
                while((len=is.read(buf))!=-1)
                {
                    System.out.println(new String(buf,0,len));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /*测试客户端*/
@Test
    public void testClient() throws IOException, InterruptedException {
        Socket s=new Socket("192.168.0.105",8888);
    System.out.println("linked");
        InetSocketAddress addh=(InetSocketAddress) s.getRemoteSocketAddress();
    System.out.println("host"+addh);
    while(true)
    {
        Thread.sleep(500);
    }

    }
    /*测试客户端写*/
    @Test
    public void testClientStream() throws IOException, InterruptedException {
        Socket s=new Socket("192.168.0.105",8888);
        //输出流
        OutputStream os =s.getOutputStream();
        os.write("hello".getBytes());
        os.flush();
        System.out.println("linked");
        InetSocketAddress addh=(InetSocketAddress) s.getRemoteSocketAddress();
        System.out.println("host"+addh);

        while(true)
        {
            Thread.sleep(500);
        }

    }

}
