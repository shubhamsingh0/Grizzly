package com.grizly.entity;

public class ProductClass {
	public int pid;
	public int pprice;
	public String pname;
	public String desc;
	public String pcategory;
	public String pbrand;
	public int prating;
	
	public ProductClass()
	{
		
	}
	public int getPrating() {
		return prating;
	}

	public void setPrating(int prating) {
		this.prating = prating;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPcategory() {
		return pcategory;
	}

	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}

	public String getPbrand() {
		return pbrand;
	}

	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}
	
	
}
