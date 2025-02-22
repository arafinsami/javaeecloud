package com.javaee.controller;

import com.javaee.dao.CountryDAO;
import com.javaee.dao.CountryDAOImpl;
import com.javaee.entity.Country;
import com.javaee.service.CountryService;
import com.javaee.service.CountryServiceImpl;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;


@WebServlet("/save")
public class CreateController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private CountryService countryService;

    public CreateController() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("save", "Save Page");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Country country = Country.builder()
                    .name(request.getParameter("name"))
                    .continent(request.getParameter("continent"))
                    .build();
            countryService.save(country);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        response.sendRedirect("/");
    }
}
