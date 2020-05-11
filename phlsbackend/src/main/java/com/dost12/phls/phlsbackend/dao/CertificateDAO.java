package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.Certification;

public interface CertificateDAO {
	Certification get(int id);
	List<Certification> list();
	boolean add(Certification category);
	boolean update(Certification category);
	boolean delete(Certification category);
}
