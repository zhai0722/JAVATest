package com.it18.learn.Netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by Think on 2017/12/26.
 */
public class nettyclient1 {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup workgroup=new NioEventLoopGroup();
        Bootstrap bootstrap=new Bootstrap();
        bootstrap.group(workgroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new nettyclientHandler());
            }
        });
        ChannelFuture future=bootstrap.connect("127.0.0.1",8379).sync();
        future.channel().writeAndFlush(Unpooled.copiedBuffer("777".getBytes()));
        future.channel().closeFuture().sync();
        workgroup.shutdownGracefully();


    }



}
