package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.CategoryService;
import com.ra.model.service.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/danh-muc")
public class CategoryController extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       if(action == null){
           showList(request,response);
       }
       switch (action){
           case "add":
               response.sendRedirect("views/add-category.jsp");
               break;
           case "edit":
               break;
           case "delete":
               break;
       }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            // lấy dữ liệu
            Category category = new Category();
            category.setCategoryName(request.getParameter("categoryName"));
            category.setCategoryStatus(Boolean.parseBoolean(request.getParameter("categoryStatus")));

            if(categoryService.saveOrUpdate(category)){
                showList(request,response);
            }
            response.sendRedirect("views/add-category.jsp?err");
        }
    }

    public void showList(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        List<Category> list = categoryService.findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("views/category.jsp").forward(request,response);
    }
}