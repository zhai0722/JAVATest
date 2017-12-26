package com.it18.learn.Netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * Created by Think on 2017/12/26.
 */
public class nettyclientHandler extends ChannelHandlerAdapter {

    public void channelread(ChannelHandlerContext ctx,Object msg) throws Exception{

        try {
            ByteBuf buf = (ByteBuf) msg;
            byte[] data = new byte[buf.readableBytes()];
            buf.readBytes(data);
            System.out.println("client:" + new String(data).trim());
        }
        finally {
            ReferenceCountUtil.release(msg);
        }



    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
