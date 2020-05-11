package com.dost12.phls.model;

import java.io.Serializable;
import com.dost12.phls.phlsbackend.dto.OnsiteAddress;
import com.dost12.phls.phlsbackend.dto.Supplier;

public class SupplierModel  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Supplier supplier;
	
	private OnsiteAddress address;

	public SupplierModel() {
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
