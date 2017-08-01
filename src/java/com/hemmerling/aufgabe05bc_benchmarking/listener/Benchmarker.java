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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rhemmerling
 */
//@WebListener
@WebServlet(name = "Benchmarker", urlPatterns = {"/Benchmarker"},
        loadOnStartup = 1)
public class Benchmarker extends HttpServlet implements ServletRequestListener {

//  long startTime;
//  long endTime;
    {
        // statischer Initalisierungsblock
        System.out.println("Statischer Initalisierungsblock");
    }

    // @Override
    public void init() throws ServletException {
        System.out.println("init()");
    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        ServletRequest request = event.getServletRequest();
        System.out.println(request + ": initialized");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
//    System.nanoTime();
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        long endTime = System.currentTimeMillis();
        ServletRequest request = event.getServletRequest();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        long startTime = Long.parseLong(request.getAttribute("startTime").toString());
        System.out.format("Dauer der Ausführung für die URL: '%s' ist: %d ms%n",
                httpRequest.getRequestURI(), endTime - startTime);
        System.out.println(request + ": destroyed");

    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
  
   