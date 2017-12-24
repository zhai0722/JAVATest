package NIO;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Think on 2017/12/24.
 */
public class NIOdemo1 {
   @Test
    public void testnio() throws IOException {
       //源文件
        FileInputStream fis=new FileInputStream("d://test.txt");
        FileChannel srcFile=fis.getChannel();
        //目标文件
        FileOutputStream fos=new FileOutputStream("d://output.txt");
        FileChannel desFile=fos.getChannel();
        //缓冲区
        ByteBuffer buf=ByteBuffer.allocateDirect(5);
        long start=System.currentTimeMillis();
        while (srcFile.read(buf)!=-1)//写入5个字节,指针到达第五个位置
        {
            buf.flip();//拍板这样使得指针指向第0个位置，写的时候就可用从0开始了 通常情况下，在准备从缓冲区中读取数据时调用flip方法。
            desFile.write(buf);
            buf.clear();//写完后clear方法将缓冲区清空，一般是在重新写缓冲区时调用。

        }
        System.out.println(System.currentTimeMillis()-start);
        fis.close();
        fos.close();

    }


}
