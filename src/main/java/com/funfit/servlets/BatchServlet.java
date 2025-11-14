package com.funfit.servlets; // ensure folder path matches

import com.funfit.dao.BatchDAO;
import com.funfit.model.Batch;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/batches")
public class BatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BatchDAO dao = new BatchDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Batch> list = dao.findAll();
            req.setAttribute("batches", list);
            req.getRequestDispatcher("/WEB-INF/views/listBatches.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String timing = req.getParameter("timing");
        int capacity = Integer.parseInt(
                req.getParameter("capacity") == null ? "0" : req.getParameter("capacity")
        );
        Batch b = new Batch();
        b.setName(name);
        b.setTiming(timing);
        b.setCapacity(capacity);
        try {
            dao.save(b);
            resp.sendRedirect(req.getContextPath()+"/batches");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    // If you're using fetch() PUT/DELETE, you may need to parse parameters manually
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr == null) { resp.sendError(HttpServletResponse.SC_BAD_REQUEST); return; }
        try {
            dao.delete(Integer.parseInt(idStr));
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
