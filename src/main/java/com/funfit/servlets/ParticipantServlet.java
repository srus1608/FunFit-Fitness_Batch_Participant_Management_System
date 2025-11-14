package com.funfit.servlets;

import com.funfit.dao.ParticipantDAO;
import com.funfit.model.Participant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/participants/*")
public class ParticipantServlet extends HttpServlet {
    private ParticipantDAO dao = new ParticipantDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String batchIdParam = req.getParameter("batchId");
        try {
            List<Participant> list;
            if (batchIdParam != null) {
                list = dao.findByBatchId(Integer.parseInt(batchIdParam));
            } else {
                list = dao.findAll();
            }
            req.setAttribute("participants", list);
            req.getRequestDispatcher("/WEB-INF/views/listParticipants.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    // Create
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer age = null;
        String ageStr = req.getParameter("age");
        if (ageStr != null && !ageStr.isEmpty()) age = Integer.valueOf(ageStr);
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        Integer batchId = null;
        String batchIdStr = req.getParameter("batch_id");
        if (batchIdStr != null && !batchIdStr.isEmpty()) batchId = Integer.valueOf(batchIdStr);

        Participant p = new Participant();
        p.setName(name); p.setAge(age); p.setPhone(phone); p.setEmail(email); p.setBatchId(batchId);
        try {
            dao.save(p);
            resp.sendRedirect(req.getContextPath()+"/participants");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    // Update
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr == null) { resp.sendError(HttpServletResponse.SC_BAD_REQUEST); return; }
        int id = Integer.parseInt(idStr);
        String name = req.getParameter("name");
        Integer age = null;
        String ageStr = req.getParameter("age");
        if (ageStr != null && !ageStr.isEmpty()) age = Integer.valueOf(ageStr);
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        Integer batchId = null;
        String batchIdStr = req.getParameter("batch_id");
        if (batchIdStr != null && !batchIdStr.isEmpty()) batchId = Integer.valueOf(batchIdStr);

        Participant p = new Participant(id, name, age, phone, email, batchId);
        try {
            dao.update(p);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    // Delete
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
