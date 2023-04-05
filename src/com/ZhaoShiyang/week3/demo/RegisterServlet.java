package com.ZhaoShiyang.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {

    Connection con = null;

    public void init() throws ServletException{
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        try{
            Statement st = con.createStatement();
            String sql = "insert into userdbtext(username, password, email, gender, birthdate)" +
                    "values(" + username + "," + password + "," + email + "," + gender + "," + birthDate + ")";
            System.out.println("sql" + sql);
            int n = st.executeUpdate(sql);
            System.out.println("n-->" + n);

           /* sql = "select id, username, password, email, gender, birthDate from userdbtext";
            ResultSet rs = st.executeQuery(sql);
            request.setAttribute("rsname",rs);

            request.getRequestDispatcher("userList.jsp").forward(request, response);*/

            response.sendRedirect("login.jsp");

        }catch (SQLException e){
            e.printStackTrace();
        }

        PrintWriter writer = response.getWriter();
        writer.println("<br>username :" + username);
        writer.println("<br>password :" + password);
        writer.println("<br>email :" + email);
        writer.println("<br>gender :" + gender);
        writer.println("<br>birth Date :" + birthDate);
        writer.close();
    }

}
