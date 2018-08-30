package com.hpe.po;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 实体类
 * 所有成员是private
 */
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
