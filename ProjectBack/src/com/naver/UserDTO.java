package com.naver;

import java.io.Serializable;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String did = null;
	private String name = null;
	private int age = 0;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String did, String name, int age) {
		super();
		this.did = did;
		this.name = name;
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDid() {
		return did;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "아이디 = " + did + " 이름 = " + name + " 나이 = " + age + "\t\n";
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
		UserDTO other = (UserDTO) obj;
		if (did == null) {
			if (other.did != null)
				return false;
		} else if (!did.equals(other.did))
			return false;
		return true;
	}

}
