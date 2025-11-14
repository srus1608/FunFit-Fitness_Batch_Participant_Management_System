package com.funfit.dao;

import com.funfit.model.Participant;
import com.funfit.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
    public void save(Participant p) throws SQLException {
        String sql = "INSERT INTO participant (name, age, phone, email, batch_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            if (p.getAge() == null) ps.setNull(2, Types.INTEGER); else ps.setInt(2, p.getAge());
            ps.setString(3, p.getPhone());
            ps.setString(4, p.getEmail());
            if (p.getBatchId() == null) ps.setNull(5, Types.INTEGER); else ps.setInt(5, p.getBatchId());
            ps.executeUpdate();
        }
    }

    public void update(Participant p) throws SQLException {
        String sql = "UPDATE participant SET name=?, age=?, phone=?, email=?, batch_id=? WHERE id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            if (p.getAge() == null) ps.setNull(2, Types.INTEGER); else ps.setInt(2, p.getAge());
            ps.setString(3, p.getPhone());
            ps.setString(4, p.getEmail());
            if (p.getBatchId() == null) ps.setNull(5, Types.INTEGER); else ps.setInt(5, p.getBatchId());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM participant WHERE id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Participant findById(int id) throws SQLException {
        String sql = "SELECT * FROM participant WHERE id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        }
        return null;
    }

    public List<Participant> findAll() throws SQLException {
        List<Participant> list = new ArrayList<>();
        String sql = "SELECT * FROM participant";
        try (Connection c = DBUtil.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) list.add(mapResultSet(rs));
        }
        return list;
    }

    public List<Participant> findByBatchId(int batchId) throws SQLException {
        List<Participant> list = new ArrayList<>();
        String sql = "SELECT * FROM participant WHERE batch_id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, batchId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(mapResultSet(rs));
        }
        return list;
    }

    private Participant mapResultSet(ResultSet rs) throws SQLException {
        Participant p = new Participant();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        int age = rs.getInt("age");
        p.setAge(rs.wasNull() ? null : age);
        p.setPhone(rs.getString("phone"));
        p.setEmail(rs.getString("email"));
        int bid = rs.getInt("batch_id");
        p.setBatchId(rs.wasNull() ? null : bid);
        return p;
    }
}
