package com.dost12.phls.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.dost12.phls.phlsbackend.dto.OnsiteAddress;
import com.dost12.phls.phlsbackend.dto.Supplier;

public class HalalRegisterModel  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Supplier supplier;
	
	private OnsiteAddress address;
	


	public HalalRegisterModel() {
		super();
		
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public OnsiteAddress getAddress() {
		return address;
	}

	public void setAddress(OnsiteAddress address) {
		this.address = address;
	}


	
	
}
