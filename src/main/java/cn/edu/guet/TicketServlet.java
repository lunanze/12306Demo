package cn.edu.guet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("application/json;charset=UTF-8");
//        String weather="{\"status\":\"1\",\"count\":\"1\",\"info\":\"OK\",\"infocode\":\"10000\",\"lives\":[{\"province\":\"北京\",\"city\":\"东城区\",\"adcode\":\"110101\",\"weather\":\"晴\",\"temperature\":\"24\",\"winddirection\":\"北\",\"windpower\":\"≤3\",\"humidity\":\"16\",\"reporttime\":\"2023-05-07 11:39:12\",\"temperature_float\":\"24.0\",\"humidity_float\":\"16.0\"}]}";
//        PrintWriter out=response.getWriter();
//        out.print(weather);
//        out.flush();
//        out.close();
        String startStation = request.getParameter("startStation");
        String endStation=request.getParameter("endStation");
        String departureDate=request.getParameter("departureDate");
        System.out.println(startStation);
        System.out.println(endStation);
        System.out.println(departureDate);

        String allTickets=TicketSearch.search(startStation,endStation,departureDate);

        //设置响应类型
        response.setContentType("application/json;UTF-8");
        PrintWriter out= response.getWriter();
        out.print(allTickets);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
