package NIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Think on 2017/12/25.
 */
public class Sender extends  Thread {

    private SocketChannel sc;

    public Sender(SocketChannel sc) {
        this.sc = sc;


    }

    public void run() {
        try {
            //读取console内容，写入sc
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            ByteBuffer buf = null;
            while ((line = br.readLine()) != null) {

                buf = ByteBuffer.allocate(1024);
                buf.put(line.getBytes());
                buf.flip();

                sc.write(buf);

                buf.clear();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}