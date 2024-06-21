package com.nt.service;

public interface ICompanyMgmtService {

	public String saveParentToChild();
	public String saveDataThroughChild();
	public void loadDataUsingParent();
	public void loadDataUsingChild();
	
	// delete the object by using parent
	public String deleteDataUsingParent(Integer parentId);
	// delete the object by using child
	public String deleteDataUsingChild(Integer childId);
	
	// delete child without parent object
	public String deleteAllTechJobFromCompany(Integer companyId);
	
	// add new child to existing Parent
	public void addNewChildToAParentById(Integer companyId);
	
}
