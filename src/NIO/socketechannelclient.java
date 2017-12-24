package NIO;


import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Think on 2017/12/24.
 */
public class socketechannelclient {

    public static void main(String[] args) throws IOException {
        //打开通道
        SocketChannel sc=SocketChannel.open();
        //套接字链接server
        InetSocketAddress addr=new InetSocketAddress("localhost",8888);
        sc.connect(addr);
        sc.configureBlocking(false);
        ByteBuffer bf= ByteBuffer.allocate(1024);
        while(sc.read(bf)!=-1) {
            bf.flip();
            System.out.println(bf);
            bf.clear();
        }


    }


}
