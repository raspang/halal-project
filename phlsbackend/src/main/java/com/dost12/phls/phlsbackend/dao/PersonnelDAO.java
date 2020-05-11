package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Personnel;
import com.dost12.phls.phlsbackend.dto.PersonnelType;

public interface PersonnelDAO {
	Personnel get(int id);
	List<Personnel> list();
	List<Personnel> list(PersonnelType personeelType);
	boolean add(Personnel personnel);
	boolean update(Personnel personnel);
	boolean delete(Personnel personnel);
}
