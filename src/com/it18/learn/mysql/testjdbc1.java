package com.it18.learn.mysql;


import org.junit.Before;
import org.junit.Test;

import java.sql.*;


/**
 * Created by Think on 2017/12/27.
 */



public class testjdbc1 {

    private  static void loaddriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    private static Connection getconn() {
        try {

            String url="jdbc:mysql://localhost:3306/javatest";
            String user="root";
            String pass="root";
            Connection conn=DriverManager.getConnection(url,user,pass);


            return  conn;


        }   catch (SQLException e) {
            e.printStackTrace();
        }
            return  null;
    }
    public  static void insertdata(){
        Connection conn=null;
        Statement st=null;
        try{
             conn=getconn();
           st=conn.createStatement();
            st.execute("insert into user(id,username) values(4, 'tom4')");

            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
            if(st!=null&&!st.isClosed()) {

                st.close(); }

                if(conn!=null &&!conn.isClosed())
                {

                conn.close();
            }

            } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    public  static  void delete()

    {
        Connection conn=null;
        Statement st=null;
        conn=getconn();
        try {
            st=conn.createStatement();
            st.execute("delete from user where id>12");
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }



    }
    public  static  void savepoint(){
        Connection conn=null;
        Statement st=null;
        conn=getconn();

        try {
            conn.setAutoCommit(false);//自动提交
            st=conn.createStatement();
            st.execute("insert into user(id,username,age) values(10, 'tom10','23')");
            Savepoint s1=conn.setSavepoint("1");//自动保存点
            st.execute("insert into user(id,username) values(11, 'tom11')");
            Savepoint s2=conn.setSavepoint("2");
            st.execute("insert into user(id,username) values(12, 'tom12')");
            Savepoint s3=conn.setSavepoint("3");
            st.execute("insert into user(id,username) values(13, 'tom13')");
            Savepoint s4=conn.setSavepoint("4");
            st.execute("insert into user(id,username) values(14, 'tom14')");
            Savepoint s5=conn.setSavepoint("5");
            conn.rollback(s2);//回滚到S2
            conn.commit();//提交
            st.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
    public static void testselect() {
        Statement st=null;
        ResultSet rs=null;
        Connection conn = getconn();
        try {
            String sname="tom10";
            int sage=23;
            conn.setAutoCommit(false);
             st = conn.createStatement();
             rs = st.executeQuery("select * from user where username='"+sname+"' and age='"+sage+"'");
            while (rs.next()) {
                int id = rs.getInt(1);//jdbc是从1开始
                String name = rs.getString("username");
                Integer age= (Integer)rs.getObject("age");//可以显示null
                System.out.println(id + ":" + "name:"+name+"age:"+age);

            }
            conn.commit();
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public static void testprepare() {

        Connection conn=null;
        PreparedStatement ppst=null;//prepare批量速度快 预处理语句 链接后不用解析
       conn = getconn();
        try {

            conn.setAutoCommit(false);
            ppst = conn.prepareStatement("insert into user(id,username,age) values(?,?,?)");//问号占位符
            ppst.setInt(1,12);
            ppst.setString(2,"J1");
            ppst.setInt(3,25);
            ppst.executeUpdate();
            conn.commit();
            ppst.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                ppst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
//测试批量
    public static void testbatchsave() {

        Connection conn=null;
        PreparedStatement ppst=null;//prepare批量速度快 预处理语句 链接后不用解析
        conn = getconn();
        int max=100005;
        try {

            conn.setAutoCommit(false);
            long start=System.currentTimeMillis();
            ppst = conn.prepareStatement("insert into user(id,username,age) values(?,?,?)");//问号占位符

            for(int i=0;i< max ;i++){



                ppst.setInt(1, i);
                ppst.setString(2, "J"+i);
                ppst.setInt(3, i%100);

                ppst.addBatch();//增加批次
                //分段提交
                if((i%5000==0&&i!=0)||i==(max-1)) {
                    ppst.executeBatch();//提交批次
                   // ppst.executeUpdate();
                    conn.commit();
                    conn.setAutoCommit(false);
                    //ppst = conn.prepareStatement("insert into user(id,username,age) values(?,?,?)");//问号占位符
                    System.out.println("------------->5000");

                }

            }

            System.out.println(System.currentTimeMillis()-start);
            conn.commit();
            ppst.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                ppst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        loaddriver();
        delete();
        insertdata();
        savepoint();
        testselect();
        testprepare();
        testbatchsave();

    }

    }
