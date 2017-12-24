package com.it18.learn.TCPIP;

import org.testng.annotations.Test;

import javax.swing.*;

/**
 * Created by Think on 2017/12/23.
 */

public class downloadUI{

    public static void main(String[] args) {
    UI u=new UI();
    u.show();
    }

}

 class UI extends JFrame{
    private  JLabel lblurl;//lburl
    private  JTextField tfurl;//url
    private  JLabel lbllocation;//文件保存位置
    private  JTextField tflocation;//文件保存位置
    private  JLabel lblcount;//文件保存位置
    private  JTextField tfcount;//线程数
    private  JButton btnstart;//开始
    private  JProgressBar bar;


    public UI()
    {


        frameInit();
    }

    private  void init()
    {
        this.setBounds(100,50,800,600);
        this.setLayout(null);
        //url标签
        lblurl=new JLabel("url地址");
        lblurl.setBounds(0,0,100,30);
        this.add(lblurl);

        tfurl=new JTextField("http://ask.csdn.net/questions/375984");
        tfurl.setBounds(0,40,800,30);
        this.add(tfurl);

        //local标签
        lbllocation=new JLabel("保存地址");
        lbllocation.setBounds(0,80,100,30);
        this.add(lbllocation);
        tflocation=new JTextField("e://z.html");
        tflocation.setBounds(0,120,800,30);
        this.add(tflocation);
        //线程数
        lblcount=new JLabel("url地址");
        lblcount.setBounds(0,160,100,30);
        this.add(lblcount);

        tfcount=new JTextField("3");
        tfcount.setBounds(0,200,800,30);
        this.add(tfcount);
        //按钮
        btnstart=new JButton("开始");
        btnstart.setBounds(0,240,100,30);
        this.add(btnstart);
        //标签
        bar=new JProgressBar();
        bar.setBounds(0,280,750,30);
        this.add(bar);
    }

}
