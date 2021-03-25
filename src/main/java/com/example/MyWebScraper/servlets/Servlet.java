package com.example.MyWebScraper.servlets;

import com.example.MyWebScraper.workers.TheTask;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {

    public Servlet() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        TheTask thetask = new TheTask();
        scheduledExecutorService.schedule(thetask,5, TimeUnit.MILLISECONDS);

        response.getWriter().println("testiing");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().println("test");
    }

    }

