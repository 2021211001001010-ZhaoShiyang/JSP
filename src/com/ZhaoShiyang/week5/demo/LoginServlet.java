package com.ZhaoShiyang.week5.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    Connection con = null;

    @Override
    public void init() throws ServletException{
        super.init();
        con = (Connection)getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String sql = "select id,username,password,email,gender,birthDate from userdbtext where username=" + username + "and password=" + password;
        try{
            ResultSet rs = con.createStatement().executeQuery(sql);
            if(rs.next()){
                /*out.println("Login Successful!!!");
                out.println("Welcome" + username);*/
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthDate",rs.getString("birthDate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request, response);
            }else{
                /*out.println("Username or password Error!!!");*/
                request.setAttribute("message","Username or password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
