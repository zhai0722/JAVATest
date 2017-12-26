package com.it18.learn.Netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;

import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.testng.annotations.Test;

import java.util.logging.SocketHandler;

/**
 * Created by Think on 2017/12/26.
 */
public class nettyserver1 {
    private  int port;
    public nettyserver1(int port)
    {
        this.port=port;

    }

    public  void run(){
        EventLoopGroup bossgroup=new NioEventLoopGroup();//用于处理服务器端接受客户端链接
        EventLoopGroup workgroup=new NioEventLoopGroup();//用于网络通信读写
try {

    ServerBootstrap boostrap = new ServerBootstrap();//辅助类工具用于服务器通道的一些列配置
    boostrap.group(bossgroup, workgroup);
     //实例化ServerSocketChannel  
    boostrap.channel(NioServerSocketChannel.class);


    boostrap.childHandler(new NettyChannelHandler());

    boostrap.option(ChannelOption.SO_BACKLOG, 1024);//设置TCP缓冲区  

      boostrap.option(ChannelOption.SO_SNDBUF, 32 * 1024);//设置发送数据缓冲大小
    boostrap.option(ChannelOption.SO_RCVBUF, 32 * 1024);//设置接受数据缓冲大小  
    boostrap.childOption(ChannelOption.SO_KEEPALIVE, true);//保持连接  

    // ChannelFuture：代表异步I/O的结果  
    ChannelFuture future = boostrap.bind(port).sync();

    future.channel().closeFuture().sync();
}
catch (Exception e)
{
    System.out.println("启动netty服务异常");
    e.printStackTrace();
}
finally {
    workgroup.shutdownGracefully();
    bossgroup.shutdownGracefully();
}


    }


    private class NettyChannelHandler extends
            ChannelInitializer<SocketChannel> {



        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            //socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(ByteOrder.BIG_ENDIAN, 64 * 1024, 0, 4, 0, 4, true));
            //socketChannel.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));
            socketChannel.pipeline().addLast(new nettyServerHandler1  ());
        }
    }

    public static void main(String[] args) {
        new nettyserver1(8888).run();
    }

}
