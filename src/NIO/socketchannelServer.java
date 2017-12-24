package NIO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by Think on 2017/12/24.
 * NIO可以非阻塞
 */
public class socketchannelServer {

    public static void main(String[] args) throws IOException {
        //打开挑选器
        Selector sel=Selector.open();
        //打开serversocketchannel
        ServerSocketChannel ssc=ServerSocketChannel.open();
        //创建绑定地址
        InetSocketAddress addr=new InetSocketAddress("0.0.0.0",8888);
        //绑定地址
        ssc.bind(addr);
        //配置阻塞模式 阻塞的模式性能差true,非阻塞性能好false
        //配置非阻塞模式
        ssc.configureBlocking(false);
        //在挑选器中注册通道,知名感兴趣的事件.
        ssc.register(sel, SelectionKey.OP_ACCEPT);
    SocketChannel sc0=null;
    ByteBuffer buf=null;
        while(true) {
            //开始挑选
            sel.select();
            System.out.println("kk");
            //处理发生事件 是一个集合用set取出
            Set<SelectionKey> keys= sel.selectedKeys();
            //循环遍历通道
            for (SelectionKey key:keys)
            {

                //得到通道注册时候感兴趣的操作
                int ops=key.interestOps();
                if (key.isValid())//可用的
                {
                  if(key.isAcceptable()){//可接受
                    //得到服务器通道
                    ServerSocketChannel ssc0=(ServerSocketChannel )key.channel();
                    //接受客户端链接,返回socketchannel
                     sc0=ssc0.accept();
                     //注册非阻塞
                     sc0.configureBlocking(false);
                    sc0.register(sel,SelectionKey.OP_READ);}

                }
                if(key.isReadable()) {//可读
                    sc0=(SocketChannel)key.channel();
                    ByteArrayOutputStream baos=new ByteArrayOutputStream();
                    buf=ByteBuffer.allocate(1024);

                    //读取客户端发送的数据
                    while(sc0.read(buf)!=0)//不是-1
                    {
                        buf.flip();
                        baos.write(buf.array(),0,buf.limit());
                        buf.clear();


                    }
                    //构造缓冲区,些回去client
                    String str="hello:"+new String(baos.toByteArray());
                    System.out.println(clientinfo(sc0.socket())+str);
                    buf=ByteBuffer.allocate(str.getBytes().length);
                    buf.put(str.getBytes());
                    sc0.write(buf);


                }
            }
            keys.clear();

            }
        //        while(true) {
        //            ssc.accept();
        //            System.out.println("kkk");
        //        }
    }

    private  static  String clientinfo(Socket socket)
    {InetSocketAddress addr=(InetSocketAddress) socket.getRemoteSocketAddress();
    String ip= addr.getAddress().getHostAddress();
        String port =addr.getPort()+"";
        return ip+":"+port;

    }

}
