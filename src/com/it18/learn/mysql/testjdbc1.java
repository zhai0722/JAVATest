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
            st.execute("delete from user");
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    public  static  void savepoint(){
        Connection conn=null;
        Statement st=null;
        conn=getconn();

        try {
            conn.setAutoCommit(false);//自动提交
            st=conn.createStatement();
            st.execute("insert into user(id,username) values(10, 'tom10')");
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

    }
    public static void main(String[] args) {
        loaddriver();
        delete();
        insertdata();
        savepoint();

    }

    }
