package com.naver;

import java.io.Serializable;

public class CiCuserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String did;
	private String name;
	private int age;
	private int cnum;
	private String cclr;

	public CiCuserDTO() {
		// TODO Auto-generated constructor stub
	}

	public CiCuserDTO(String did, String name, int age, int cnum, String cclr) {
		super();
		this.did = did;
		this.name = name;
		this.age = age;
		this.cnum = cnum;
		this.cclr = cclr;
	}

	String getDid() {
		return did;
	}

	void setDid(String did) {
		this.did = did;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	int getCnum() {
		return cnum;
	}

	void setCnum(int cnum) {
		this.cnum = cnum;
	}

	String getCclr() {
		return cclr;
	}

	void setCclr(String cclr) {
		this.cclr = cclr;
	}

	static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((did == null) ? 0 : did.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CiCuserDTO other = (CiCuserDTO) obj;
		if (did == null) {
			if (other.did != null)
				return false;
		} else if (!did.equals(other.did))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CiCuserDTO [did=" + did + ", name=" + name + ", age=" + age + ", cnum=" + cnum + ", cclr=" + cclr + "]";
	}

}
