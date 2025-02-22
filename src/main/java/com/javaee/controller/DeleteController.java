package com.javaee.controller;

import com.javaee.service.CountryService;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private CountryService countryService;

    public DeleteController() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int countryId = Integer.parseInt(request.getParameter("countryId"));
            countryService.delete(countryId);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        response.sendRedirect("/");
    }
}
