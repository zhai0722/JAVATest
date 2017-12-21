package com.it18.learn.IO;

import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;

/**
 * Created by Think on 2017/12/20.
 * 字符流 文本读取比较好 reader
 * 字节流 图片等 stream
 */
@Test
public class Filestreamdemo1 {
    public void textcopy(){
        try {
            FileInputStream fis=new FileInputStream("d://IdeaProjects//JAVATest//input.jpg");
            FileOutputStream fos=new FileOutputStream("d://IdeaProjects//JAVATest//1.jpg");
            byte[] buffer=new byte[1024];
            int len=0;
            while ((len=fis.read(buffer))!=-1) {
                //fis.read(buffer);
                fos.write(buffer,0,len);
            }
            fis.close();
            fos.close();
            System.out.println("completed");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
@Test
    public void testwriterratio() throws Exception
    {
        FileOutputStream fos=new FileOutputStream("D:/test.txt");
        byte[] arr=new byte[1024];//改成1023后
        Arrays.fill(arr,(byte)97);
        for (int i=0;i<1024*12;i++)
        {
            fos.write(arr);
fos.close();

    }  }
    @Test
    public void testwritecharset() throws Exception {
        FileOutputStream fos = new FileOutputStream("D:/test.txt");
        byte[] arr = new byte[1023];//改成1023后
        Arrays.fill(arr, (byte) 97);

            fos.write(arr);
            fos.write("\ud585\u4e2d".getBytes("utf-8"));//插入中文韩文

        fos.close();

    }
    @Test
    //字节流
    public void testfuzafile() throws IOException {
        FileInputStream fis=new FileInputStream("d://test.txt");
        byte[] buf=new byte[1024];
        byte[] buf1=new byte[fis.available()];
        int len=0;
        while ((len=fis.read(buf))!=-1)//buf1一次性都满缓存 可以避免乱码
        {
            System.out.println(new String(buf,"utf-8"));//用1024读会出现乱码 因为韩语是3字节

        }

        fis.close();
    }
//字符流
    public void testfilereader() throws IOException {
    FileReader reader=new FileReader("d://test.txt");
    char[] buf=new char[5];
    int len=0;
    while((len=reader.read(buf))!=-1) {
      //  reader.read(buf);
        System.out.println(new String(buf,0,len));
    }
}
    //将字节流转化成字符流
    public void testinputstreamreader() throws IOException {
        FileInputStream fis=new FileInputStream("d://test.txt");
        InputStreamReader reader=new InputStreamReader(fis,"utf-8");
        char[] buf=new char[5];
        int len=0;
        while((len=reader.read(buf))!=-1) {
            //  reader.read(buf);
            System.out.println(new String(buf,0,len));
        }
        reader.close();
    }

/*标准流操作
* */
@Test
public  void teststandardinputstream(){
    FileReader reader=null;
    try {
         reader =new FileReader("d://test.txt");
        char[] buf=new char[1024];
        int len=0;
        while ((len=reader.read())!=-1)
        {
            System.out.println(new String(buf,0,len));
        }
    } catch (IOException e) {

        e.printStackTrace();
    }
    finally {
        try {
            if(reader!=null)
            {
            reader.close();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 @Test
    public  void testfilewriter(){

        FileWriter w=null;

        try {
           w =new FileWriter("d://test.txt",true);
            for(int i=0;i<100;i++){ w.write("tom"+i);}
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                w.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
@Test
    public void  testbufferedreader() throws IOException //缓冲区字符流会将更多内容读取
    {
        FileReader read=new FileReader("d://test.txt");
        BufferedReader br=new BufferedReader(read);
        String line=null;
        while ((line=br.readLine())!=null)
        {
            System.out.println();
        }

    br.close();

    }
    public  void testinputstreamskip() throws IOException {
        FileInputStream fis=new FileInputStream("d://test.txt");
        System.out.println((char)fis.read());
        fis.skip(1036);
        System.out.println((char)fis.read());
        System.out.println((char)fis.read());
        fis.close();

    }





}
