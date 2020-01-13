package com.naver;

import java.io.Serializable;

public class CInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cid = null;
	private int cnum = 0;
	private String cclr = null;

	public CInfoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CInfoDTO(String did, int number, String cclr) {
		super();
		this.cid = did;
		this.cnum = number;
		this.cclr = cclr;
	}

	public String getDid() {
		return cid;
	}

	public void setDid(String did) {
		this.cid = did;
	}

	public int getNumber() {
		return cnum;
	}

	public void setNumber(int number) {
		this.cnum = number;
	}

	public String getCclr() {
		return cclr;
	}

	public void setCclr(String cclr) {
		this.cclr = cclr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cinfo [did=" + cid + ", number=" + cnum + ", cclr=" + cclr + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cnum;
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
		CInfoDTO other = (CInfoDTO) obj;
		if (cnum != other.cnum)
			return false;
		return true;
	}

	public String getcid() {
		return cid;
	}

	public void setcid(String cid) {
		this.cid = cid;
	}

}
