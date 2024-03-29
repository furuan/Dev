package com.bo.listener;

import com.bo.entity.Book;
import com.bo.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jw
 * @ClassName ContextLoaderListener
 * @Description 上下文加载监听，在服务器启动的时候即刻生效，用来生成用户数据和图书数据
 * @Date 2019/9/27
 * @Version 1.0
 **/

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    /**
     * @Description 容器初始化方法
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器启动");
        //创建并生成用户数据列表
        List<User> userList = new ArrayList<>(3);
        User[] users = {
                new User(1, "aaa", "698d51a19d8a121ce581499d7b701668", "星河", "user1.jpg", "江苏南京", LocalDate.of(2018, 6, 11)),
                new User(2, "bbb@qq.com", "698d51a19d8a121ce581499d7b701668", "月亮喝醉了吗", "user2.jpg", "浙江杭州", LocalDate.of(2019, 2, 18)),
                new User(3, "ccc@qq.com", "698d51a19d8a121ce581499d7b701668", "星星爱吃糖", "user3.jpg", "湖北武汉", LocalDate.of(2019, 8, 19))
        };
        userList = Arrays.asList(users);

        //创建并生成图书数据列表
        List<Book> bookList = new ArrayList<>(10);
        Book[] books = {
                new Book(1,"《陈情令》", "1.jpg", "墨香铜臭"),
                new Book(2,"《一个人不要怕》", "2.jpg", "素黑"),
                new Book(3,"《摆渡人》", "3.jpg", "克莱尔麦克福尔"),
                new Book(4,"《战争与和平》", "4.jpg", "列夫托尔斯泰"),
                new Book(5,"《悲伤逆流成河》", "5.jpg", "郭敬明"),
                new Book(6,"《生活，是很好玩的》", "6.jpg", "汪曾祺"),
                new Book(7,"《活着》", "7.jpg", "余华"),
                new Book(8,"《夜色温柔》", "8.jpg", "费朗西斯斯科特"),
                new Book(9,"《有匪》", "9.jpg", "priest"),
                new Book(10,"《最好的我们》", "10.jpg", "八月长安"),
                new Book(11,"《花田半亩》", "11.jpg", "田维"),
                new Book(12,"《人间失格》", "12.jpg", "太宰治"),

        };
        bookList = Arrays.asList(books);

        //获得全局变量
        ServletContext servletContext = sce.getServletContext();
        //设置全局变量属性，将用户和图书列表数据记入，整个应用可以共享
        servletContext.setAttribute("userList", userList);
        servletContext.setAttribute("bookList", bookList);
    }

    /**
     * 销毁方法
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁");
    }
}
