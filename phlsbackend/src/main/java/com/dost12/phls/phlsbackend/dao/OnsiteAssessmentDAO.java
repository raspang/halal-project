package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.OnsiteAssessment;

public interface OnsiteAssessmentDAO {
				 
	OnsiteAssessment get(int id);
	List<OnsiteAssessment> list();
	boolean add(OnsiteAssessment category);
	boolean update(OnsiteAssessment category);
	boolean delete(OnsiteAssessment category);
	
}
