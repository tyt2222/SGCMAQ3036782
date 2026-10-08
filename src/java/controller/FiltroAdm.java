/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import framework.dao.TipoUsuario;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(filterName = "FiltroAdm", urlPatterns = {"/home/app/adm/*"})
public class FiltroAdm implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession sessao = httpServletRequest.getSession(false);      
        TipoUsuario tp = (TipoUsuario) sessao.getAttribute("tipo_usuario_sessao");
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        
       
        if (tp.getModuloAdministrativo().equals("S")) {
            chain.doFilter(request, response);
        } else {
            httpServletResponse.sendError(403);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
