package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class JobRowMapper implements RowMapper<Job> {

	@Override
	public Job mapRow(ResultSet rs, int arg1) throws SQLException {
          Job j = new Job();
          j.setId( rs.getString("job_id"));
          j.setTitle( rs.getString("job_title"));
          return j;
	}

	
}
