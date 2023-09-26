package com.boot.vamsi.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.boot.vamsi.model.InsurancePackage;

public class InsurancePackageMapper implements RowMapper<InsurancePackage> {

	public InsurancePackage mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		InsurancePackage insurancePackage = new InsurancePackage();
		insurancePackage.setId(resultSet.getLong("insp_id"));
		insurancePackage.setTitle(resultSet.getString("insp_title"));
		insurancePackage.setDescription(resultSet.getString("insp_desc"));
		insurancePackage.setStatus(resultSet.getString("insp_status"));
		insurancePackage.setRangeStart(resultSet.getDouble("insp_range_start"));
		insurancePackage.setRangeEnd(resultSet.getDouble("insp_range_end"));
		insurancePackage.setAgeLimitStart(resultSet.getInt("insp_agelimit_start"));
		insurancePackage.setAgeLimitEnd(resultSet.getInt("insp_agelimit_end"));
		return insurancePackage;
	}
}

