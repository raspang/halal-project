package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Setting;

public interface SettingDAO {
	Setting get(int id);
	List<Setting> list();
	boolean add(Setting setting);
	boolean update(Setting setting);
	boolean delete(Setting setting);

}
