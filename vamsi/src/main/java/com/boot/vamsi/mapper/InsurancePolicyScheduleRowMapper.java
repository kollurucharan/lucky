package com.boot.vamsi.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.boot.vamsi.model.InsurancePolicySchedule;

public class InsurancePolicyScheduleRowMapper implements RowMapper<InsurancePolicySchedule> {
	@Override
	public InsurancePolicySchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
		InsurancePolicySchedule policySchedule = new InsurancePolicySchedule();
		policySchedule.setIplcId(rs.getInt("iplc_id"));
		policySchedule.setIplcSindex(rs.getShort("iplc_sindex"));
		policySchedule.setIplcDate(rs.getDate("iplc_date"));
		policySchedule.setIplcPremium(rs.getDouble("iplc_premium"));
		policySchedule.setIplcPaidDate(rs.getDate("iplc_paid_date"));
		return policySchedule;
	}
}