package com.it18.learn.Netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.EventExecutorGroup;


/**
 * Created by Think on 2017/12/26.
 */
public class nettyServerHandler1 extends ChannelHandlerAdapter{

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf=(ByteBuf)msg;
        byte[] data=new byte[buf.readableBytes()];
        buf.readBytes(data);
        String request=new String(data,"utf-8");
        System.out.println("server"+request);
        //写给客户
        String response="feedbak message";
        ctx.writeAndFlush(Unpooled.copiedBuffer("888".getBytes()));
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
