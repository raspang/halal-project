package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.CertificationDetail;

public interface CertificationDetailDAO {
	CertificationDetail get(int id);
	List<CertificationDetail> list();
	boolean add(CertificationDetail category);
	boolean update(CertificationDetail category);
	boolean delete(CertificationDetail category);
}
