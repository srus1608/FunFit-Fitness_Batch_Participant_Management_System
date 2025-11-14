package com.funfit.dao;

import com.funfit.model.Batch;
import com.funfit.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BatchDAO {
    public void save(Batch b) throws SQLException {
        String sql = "INSERT INTO batch (name, timing, capacity) VALUES (?, ?, ?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, b.getName());
            ps.setString(2, b.getTiming());
            ps.setInt(3, b.getCapacity());
            ps.executeUpdate();
        }
    }

    public void update(Batch b) throws SQLException {
        String sql = "UPDATE batch SET name=?, timing=?, capacity=? WHERE id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, b.getName());
            ps.setString(2, b.getTiming());
            ps.setInt(3, b.getCapacity());
            ps.setInt(4, b.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM batch WHERE id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Batch findById(int id) throws SQLException {
        String sql = "SELECT * FROM batch WHERE id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Batch(rs.getInt("id"), rs.getString("name"), rs.getString("timing"), rs.getInt("capacity"));
            }
        }
        return null;
    }

    public List<Batch> findAll() throws SQLException {
        List<Batch> list = new ArrayList<>();
        String sql = "SELECT * FROM batch";
        try (Connection c = DBUtil.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Batch(rs.getInt("id"), rs.getString("name"), rs.getString("timing"), rs.getInt("capacity")));
            }
        }
        return list;
    }
}
