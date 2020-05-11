package com.dost12.phls.controller.lab;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dost12.phls.phlsbackend.dao.HalalAnalysisReportDAO;
import com.dost12.phls.phlsbackend.dao.NutritionFactsResultDAO;
import com.dost12.phls.phlsbackend.dao.OnsiteAddressDAO;
import com.dost12.phls.phlsbackend.dao.PersonnelDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dto.HalalAnalysisReport;
import com.dost12.phls.phlsbackend.dto.NutritionFactsParameter;
import com.dost12.phls.phlsbackend.dto.NutritionFactsResult;
import com.dost12.phls.phlsbackend.dto.NutritionalTypeName;
import com.dost12.phls.phlsbackend.dto.OnsiteAddress;
import com.dost12.phls.phlsbackend.dto.Personnel;
import com.dost12.phls.phlsbackend.dto.PersonnelType;
import com.dost12.phls.phlsbackend.dto.Product;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.util.JasperReportUtil;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;

@Controller
@RequestMapping("/laboratory")
public class ReportController {

	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private HalalAnalysisReportDAO halalAnalysisReportDAO;
	
	@Autowired
	private NutritionFactsResultDAO nutritionFactsResultDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private OnsiteAddressDAO onsiteAddressDAO;
	
	@Autowired
	private PersonnelDAO personnelDAO;

	
	
	@RequestMapping(value = "/supplier/pdf")
	public String generateReportCompany(@Valid @RequestParam(name = "id", required = false) String id,
			HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException, NamingException {

		
		Supplier supplier = new Supplier();
		
		if(id.length() > 0)
			supplier = supplierDAO.get(Integer.valueOf(id));
		
		String reportFileName = "company";
		JasperReportUtil jrdao = new JasperReportUtil();

		List<Map<String, ?>> fields = new ArrayList<Map<String, ?>>();
		Map<String, Object> m = new HashMap<String, Object>();
		
		Map<String, Object> hmParams = new HashMap<String, Object>();

		BufferedImage image1 =  null;
		BufferedImage image2 =  null;
		
		try {
		 File initialImage = new File(request.getSession().getServletContext().getRealPath("/jasper/dost.png"));
		 image1 = ImageIO.read(initialImage);
		 initialImage = new File(request.getSession().getServletContext().getRealPath("/jasper/halallogo.png"));
		 image2 = ImageIO.read(initialImage);
		}catch(Exception e) {}
	
		hmParams.put("dost", image1);
		hmParams.put("halal", image2);
		
/*		String companyAddress = "";
		if(onsiteAddressDAO.list(supplier).size() > 0)
			companyAddress = onsiteAddressDAO.list(supplier).get(0).getAddressLineOne()+" "+onsiteAddressDAO.list(supplier).get(0).getAddressLineTwo()+" "+onsiteAddressDAO.list(supplier).get(0).getCity();*/
		
		if(supplier.getActive()) {
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "COMPANY NAME");
			m.put("companyfieldvalue",supplier.getNameOfEstablishment());
			fields.add(m);

		
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "COMPANY ADDRESS");
			m.put("companyfieldvalue", supplier.getAddressOfEstablishment());
			fields.add(m);

			
			m = new HashMap<String, Object>();
			m.put("companyfield", "TELEPHONE");
			m.put("companyfieldvalue", supplier.getTelNo());
			fields.add(m);

			m = new HashMap<String, Object>();
			m.put("companyfield", "FAX");
			m.put("companyfieldvalue", supplier.getFax());
			fields.add(m);
	
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "AUTHORIZED PERSON");
			m.put("companyfieldvalue", supplier.getPersonInvolved());
			fields.add(m);
	
			m = new HashMap<String, Object>();
			m.put("companyfield", "POSITION");
			m.put("companyfieldvalue", supplier.getPosition());
			fields.add(m);
	
			m = new HashMap<String, Object>();
			m.put("companyfield", "EMAIL");
			m.put("companyfieldvalue", supplier.getEmail());
			fields.add(m);
			
	
			m = new HashMap<String, Object>();
			m.put("companyfield", "WEBSITE");
			m.put("companyfieldvalue", supplier.getWebsite());
			fields.add(m);

			m = new HashMap<String, Object>();
			m.put("companyfield", "REASON FOR Application");
			m.put("companyfieldvalue", supplier.getReason());
			fields.add(m);
			


			m = new HashMap<String, Object>();
			m.put("companyfield", "NUMBER OF EMPLOYEES");
			m.put("companyfieldvalue", String.valueOf(supplier.getNumOfEmployees()));
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "PRODUCTION AREA SIZE");
			m.put("companyfieldvalue",  supplier.getProductionAreaSize());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "INDOOR AREA (m2)");
			m.put("companyfieldvalue", supplier.getIndoorArea());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "OPEN AREA (m2)");
			m.put("companyfieldvalue", supplier.getOpenArea());
			fields.add(m);
			
			// ADDRESSES FACILIIES
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "NUMBER OF RAW MATERIAL WAREHOUSES");
			m.put("companyfieldvalue", supplier.getNamesOfRawMaterials());
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "NUMBER OF FINISHED PRODUCTS WAREHOUSES");
			m.put("companyfieldvalue", supplier.getNumProductsWarehouses());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "PRODUCTION CAPACITY (TON/YEAR)");
			m.put("companyfieldvalue", supplier.getProductionCapacity());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "PRODUCTION LINES");
			m.put("companyfieldvalue", supplier.getProductionLines());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "CUSTOM PRODUCTION (LIKE PRIVATE LABEL)");
			m.put("companyfieldvalue", supplier.getCustomProduction());
			fields.add(m);
			
			// PRODUCT GROUP
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "BRANDS OF PRODUCTS");
			m.put("companyfieldvalue", supplier.getProductBrands());
			fields.add(m);

			m = new HashMap<String, Object>();
			m.put("companyfield", "PRODUCT VARIETIES");
			m.put("companyfieldvalue", supplier.getProductVarieties());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "STATE PRODUCTS THAT WILL NOT BE HALAL CERTIFIED (IF ANY)");
			m.put("companyfieldvalue", supplier.getProductNotHalal());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "LIST OF RAW MATERIALS USED");
			m.put("companyfieldvalue", supplier.getNamesOfRawMaterials());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "NAMES OF SUPPLIES");
			m.put("companyfieldvalue", supplier.getNamesOfSuppliers());
			fields.add(m);
			
			m = new HashMap<String, Object>();
			m.put("companyfield", "PROCESS FLOW FOR EACH PRODUCT");
			m.put("companyfieldvalue", supplier.getProductsProcess());
			fields.add(m);
			
		}
		

		JasperReport jasperReport = jrdao.getCompiledFile(reportFileName, request);


		
		try {

			jrdao.generateReportPDF(response, hmParams, fields,  jasperReport);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // For
			// PDF
			// report

		return null;
	}
	
	@RequestMapping(value = "/product/{id}/halalanalysis/pdf")
	public String generateReportHalalProduct(@PathVariable int id,
			@Valid @RequestParam(name = "halalanalysisid", required = false) String halalanalysisid,
			HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException, NamingException {

		Product product = null;
		HalalAnalysisReport halalAnalysisReport = null;
		try {
			product = productDAO.get(id);
			halalAnalysisReport = halalAnalysisReportDAO.get(Integer.parseInt(halalanalysisid));
		}catch(Exception e) {}
		
		String reportFileName = "halalform";
		JasperReportUtil jrdao = new JasperReportUtil();

		List<Map<String, ?>> fields = new ArrayList<Map<String, ?>>();
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object> hmParams = new HashMap<String, Object>();

		BufferedImage image1 =  null;
		BufferedImage image2 =  null;
		
		try {
		 File initialImage = new File(request.getSession().getServletContext().getRealPath("/jasper/dost.png"));
		 image1 = ImageIO.read(initialImage);
		 initialImage = new File(request.getSession().getServletContext().getRealPath("/jasper/halallogo.png"));
		 image2 = ImageIO.read(initialImage);
		}catch(Exception e) {}
	
		hmParams.put("dost", image1);
		hmParams.put("halal", image2);
		

		if (product != null && halalAnalysisReport != null) {
			if(personnelDAO.list(PersonnelType.DIRECTOR).size() > 0) {
				Personnel director = personnelDAO.list(PersonnelType.DIRECTOR).get(0);
				hmParams.put("directorName", director.getName2());
				hmParams.put("directorTittle", director.getIncharge());
			}
			if(personnelDAO.list(PersonnelType.MANAGER).size() > 0) {
				Personnel labmanager = personnelDAO.list(PersonnelType.MANAGER).get(0);
				hmParams.put("labmanagerName", labmanager.getName2());
				hmParams.put("labmanagerTittle", labmanager.getIncharge());
			}
			
			Personnel analyst = halalAnalysisReport.getAnalyst();;
			hmParams.put("analystName", analyst.getName2());
			hmParams.put("analystTittle", analyst.getIncharge());
			
			
			String dateSubmitted = halalAnalysisReport.getDateSubmitted() != null ? halalAnalysisReport.getDateSubmitted().toString() : "";
			String dateAnalyzed = halalAnalysisReport.getFromDateAnalyzed() != null ? halalAnalysisReport.getFromDateAnalyzed().toString() : "";
								dateAnalyzed +=	halalAnalysisReport.getToDateAnalyzed() != null && !halalAnalysisReport.getToDateAnalyzed().equals(halalAnalysisReport.getFromDateAnalyzed())
											? "  -  "+halalAnalysisReport.getToDateAnalyzed().toString() : "";
			String dateReported = halalAnalysisReport.getDateReported() != null ? halalAnalysisReport.getDateReported().toString() : "";
			       
			String sampleSubmittedBy = product.getSupplier().getPersonInvolved();
			String nameOfCompany = product.getSupplier().getNameOfEstablishment();
			String addressOfCompany = product.getSupplier().getAddressOfEstablishment();
			String testMethod =  halalAnalysisReport.getTestMethod();
			
			m.put("laboratoryNo", String.valueOf(halalAnalysisReport.getId()));
			m.put("dateSubmitted", dateSubmitted ) ;
			m.put("dateAnalyzed", dateAnalyzed ); 
			m.put("dateReported", dateReported );
			m.put("sampleSubmittedBy", sampleSubmittedBy );
			m.put("nameOfCompany", nameOfCompany );
			m.put("address",  addressOfCompany);
				
			m.put("sampleCode", halalAnalysisReport.getCode());
			m.put("sampleDescription", product.getName());
			m.put("testMethod",testMethod );
			m.put("parameter", halalAnalysisReport.getHalalParameter().getName());
			m.put("result", String.valueOf(halalAnalysisReport.getResult()));
			m.put("unit", halalAnalysisReport.getUnit() );
			fields.add(m);
			
			
		}

		JasperReport jasperReport = jrdao.getCompiledFile(reportFileName, request);
		
		try {

			jrdao.generateReportPDF(response, hmParams, fields,  jasperReport);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // For
			// PDF
			// report

		return null;
	}
	
	
	@RequestMapping(value = "/product/{id}/nutritionfacts/pdf")
	public String generateReportNutritionProduct(@PathVariable int id,
			@Valid @RequestParam(name = "nutritionfactsid", required = false) String nutritionfactsid,
			HttpServletRequest request, HttpServletResponse response)
			throws JRException, IOException, NamingException {

		Product product = null;
		NutritionFactsResult nutritionFactsResult = null;
		try {
			product = productDAO.get(id);
			nutritionFactsResult = nutritionFactsResultDAO.get(Integer.parseInt(nutritionfactsid));
		}catch(Exception e) {}
		
		String reportFileName = "nutritionform";
		JasperReportUtil jrdao = new JasperReportUtil();

		List<Map<String, ?>> fields = new ArrayList<Map<String, ?>>();
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, Object> hmParams = new HashMap<String, Object>();

		BufferedImage image1 =  null;
		BufferedImage image2 =  null;
		
		try {
		 File initialImage = new File(request.getSession().getServletContext().getRealPath("/jasper/dost.png"));
		 image1 = ImageIO.read(initialImage);
		 initialImage = new File(request.getSession().getServletContext().getRealPath("/jasper/halallogo.png"));
		 image2 = ImageIO.read(initialImage);
		}catch(Exception e) {}
	
		hmParams.put("dost", image1);
		hmParams.put("halal", image2);
		

		if (product != null && nutritionFactsResult != null) {
			if(personnelDAO.list(PersonnelType.DIRECTOR).size() > 0) {
				Personnel director = personnelDAO.list(PersonnelType.DIRECTOR).get(0);
				hmParams.put("directorName", director.getName2());
				hmParams.put("directorTittle", director.getIncharge());
			}
			if(personnelDAO.list(PersonnelType.MANAGER).size() > 0) {
				Personnel labmanager = personnelDAO.list(PersonnelType.MANAGER).get(0);
				hmParams.put("labmanagerName", labmanager.getName2());
				hmParams.put("labmanagerTittle", labmanager.getIncharge());
			}
			
			Personnel analyst = nutritionFactsResult.getAnalyst();;
			hmParams.put("analystName", analyst.getName2());
			hmParams.put("analystTittle", analyst.getIncharge());
			
			
		
/*			String dateAnalyzed = halalAnalysisReport.getFromDateAnalyzed() != null ? halalAnalysisReport.getFromDateAnalyzed().toString() : "";
								dateAnalyzed +=	halalAnalysisReport.getToDateAnalyzed() != null && !halalAnalysisReport.getToDateAnalyzed().equals(halalAnalysisReport.getFromDateAnalyzed())
											? "  -  "+halalAnalysisReport.getToDateAnalyzed().toString() : "";
											
			String dateReported = halalAnalysisReport.getDateReported() != null ? halalAnalysisReport.getDateReported().toString() : "";
			       
			String sampleSubmittedBy = product.getSupplier().getPersonInvolved();
			String nameOfCompany = product.getSupplier().getNameOfEstablishment();
			String addressOfCompany = product.getSupplier().getAddressOfEstablishment();
			String testMethod =  halalAnalysisReport.getTestMethod();
			
			m.put("laboratoryNo", String.valueOf(nutritionFactsResult.getId()));
			m.put("dateAnalyzed", dateAnalyzed ); 
			m.put("dateReported", dateReported );
			m.put("sampleSubmittedBy", sampleSubmittedBy );
			m.put("nameOfCompany", nameOfCompany );
			m.put("address",  addressOfCompany);
				
			m.put("sampleCode", halalAnalysisReport.getCode());
			m.put("sampleDescription", product.getName());
			m.put("testMethod",testMethod );
			m.put("parameter", halalAnalysisReport.getHalalParameter().getName());
			m.put("result", String.valueOf(halalAnalysisReport.getResult()));
			m.put("unit", halalAnalysisReport.getUnit() );*/
			m.put("sampleDescription", product.getName());
			fields.add(m);
			
			hmParams.put("referenceno", String.valueOf(nutritionFactsResult.getId()));
			hmParams.put("dateofevaluation", nutritionFactsResult.getDateEvaluationStr());
			hmParams.put("productname", product.getName());
			hmParams.put("nameofcompany", product.getSupplier().getNameOfEstablishment());
			hmParams.put("address", product.getSupplier().getAddressOfEstablishment());
			
				
			for(NutritionFactsParameter nutritionfactparam : nutritionFactsResult.getNutritionFactsParameters()) {
				
				if(nutritionfactparam.getName().equals(NutritionalTypeName.CALORIES.getNutritionalTypeName()))
					hmParams.put("calories", nutritionfactparam.getValue());
				
				if(nutritionfactparam.getName().equals(NutritionalTypeName.CALORIES_FAT.getNutritionalTypeName()))
					hmParams.put("caloriesfat", nutritionfactparam.getValue());
				
				if(nutritionfactparam.getName().equals(NutritionalTypeName.TOTAL_FAT.getNutritionalTypeName())) {
					hmParams.put("totalfat", nutritionfactparam.getValue());
					hmParams.put("totalfatdailyvalues", nutritionfactparam.getValue2());
				}
				if(nutritionfactparam.getName().equals(NutritionalTypeName.SODIUM.getNutritionalTypeName())) {
					hmParams.put("sodium", nutritionfactparam.getValue());
					hmParams.put("sodiumdailyvalues", nutritionfactparam.getValue());
				}
				if(nutritionfactparam.getName().equals(NutritionalTypeName.TOTAL_CARBOHYDRATES.getNutritionalTypeName())) {
					hmParams.put("totalcarbohydrates",nutritionfactparam.getValue());
					hmParams.put("totalcarbohydratesdailyvalues", nutritionfactparam.getValue());
				}
				if(nutritionfactparam.getName().equals(NutritionalTypeName.PROTEIN.getNutritionalTypeName())) 
					hmParams.put("protein", nutritionfactparam.getValue());
				if(nutritionfactparam.getName().equals(NutritionalTypeName.SUGAR.getNutritionalTypeName())) 
					hmParams.put("sugar", nutritionfactparam.getValue());
				if(nutritionfactparam.getName().equals(NutritionalTypeName.VITAMIN_C.getNutritionalTypeName())) {
					hmParams.put("vitaminc", nutritionfactparam.getValue());
					hmParams.put("vitamincdailyvalues", nutritionfactparam.getValue());
				}
			}
				

		}

		JasperReport jasperReport = jrdao.getCompiledFile(reportFileName, request);
		
		try {

			jrdao.generateReportPDF(response, hmParams, fields,  jasperReport);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // For
			// PDF
			// report

		return null;
	}
	

}
