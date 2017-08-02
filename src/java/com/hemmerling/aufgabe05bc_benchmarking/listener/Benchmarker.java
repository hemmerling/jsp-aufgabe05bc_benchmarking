/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe05bc_benchmarking.listener;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rhemmerling
 */
@WebListener
public class Benchmarker implements ServletRequestListener {

    static {
        // statischer Initalisierungsblock
        System.out.println("Static initalisation block");
    }

    // @Override
//    public void init() throws ServletException {
//        System.out.println("init()");
//    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        ServletRequest request = event.getServletRequest();
        System.out.println(request + ": initialized");
        long startTime; 
        startTime = System.currentTimeMillis();
        // startTime = System.nanoTime();
        request.setAttribute("START_TIME", startTime);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        long endTime;
        endTime = System.currentTimeMillis();
        // endTime = System.nanoTime();
        ServletRequest request = event.getServletRequest();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        long startTime = Long.parseLong(request.getAttribute("START_TIME").toString());
        long duration = endTime - startTime;
        String requestURI = httpRequest.getRequestURI();
        System.out.format("Execution time for the URL: '%s' ist: %d ms%n",
                          requestURI, duration);
        System.out.println(request + ": destroyed");
        }
}
  
   