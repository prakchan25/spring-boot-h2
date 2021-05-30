package com.sunriseyonder.sb.h2repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sunriseyonder.sb.entity.Billionaires;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BillionairesRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class BillionaresRowMapper implements RowMapper<Billionaires> {
        @Override
        public Billionaires mapRow(ResultSet rs, int rowNum) throws SQLException {
            Billionaires billionaire = new Billionaires();
            billionaire.setId(rs.getInt("ID"));
            billionaire.setFirstName(rs.getString("FIRST_NAME"));
            billionaire.setLastName(rs.getString("LAST_NAME"));
            billionaire.setCareer(rs.getString("CAREER"));
            return billionaire;
        }
    }

    public List<Billionaires> findAll() {
        return jdbcTemplate.query("SELECT * FROM BILLIONAIRES", new BillionaresRowMapper());
    }

    public Billionaires findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM BILLIONAIRES WHERE ID=?", new Object[] { id },
                new BeanPropertyRowMapper<Billionaires>(Billionaires.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM BILLIONAIRES WHERE ID=?", new Object[] { id });
    }

    public int insert(Billionaires billionaire) {
        return jdbcTemplate.update("INSERT INTO BILLIONAIRES (ID, FIRST_NAME, LAST_NAME,CAREER) " + "values(?, ?, ?,?)",
                new Object[] { billionaire.getId(), billionaire.getFirstName(), billionaire.getLastName(),billionaire.getCareer() });
    }

    public int update(Billionaires billionaire) {
        return jdbcTemplate.update("UPDATE BILLIONAIRES " + " SET FIRST_NAME = ?, LAST_NAME = ? ,CAREER = ? " + " where id = ?",
                new Object[] { billionaire.getFirstName(), billionaire.getLastName(), billionaire.getCareer(),billionaire.getId() });
    }

}
