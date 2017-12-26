package NIO;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by Think on 2017/12/24.
 */
public class socketechannelclient {

    public static void main(String[] args) throws IOException {
        //挑选器
        Selector sel = Selector.open();
        //打开通道
        SocketChannel sc = SocketChannel.open();
        //套接字链接server
        InetSocketAddress addr = new InetSocketAddress("localhost", 8888);
        sc.connect(addr);
        //非阻塞
        sc.configureBlocking(false);
        //挑选器注册
        sc.register(sel, SelectionKey.OP_READ);

        //开启发送器线程 放在while之前是因为while是死循环，放后面是不可到达代码
        new Sender(sc).start();
        //
//        ByteBuffer wbuf=ByteBuffer.allocate(1024);
//        wbuf.put("hello".getBytes());
//        wbuf.flip();
//
//        sc.write(wbuf);
//        System.out.println("over");
        ByteBuffer bf = ByteBuffer.allocate(1024);
        //开始挑选
        while (true) {

            //
            sel.select();
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            while (sc.read(bf) != 0) {
                bf.flip();
                baos.write(bf.array(),0,bf.limit());
                System.out.println(bf);//查看bytebuffer
                bf.clear();
            }
            String str=new String(baos.toByteArray());
            System.out.println(str);


        }
    }


}
