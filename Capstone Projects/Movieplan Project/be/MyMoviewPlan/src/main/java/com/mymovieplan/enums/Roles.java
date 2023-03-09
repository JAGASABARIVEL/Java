package com.mymovieplan.enums;

public enum Roles {
	CUSTOMER,
	ADMIN,
	ROOT;
	
	public static Roles getCustomerRoles() {
		return Roles.ADMIN;
	}
	
	public static Roles getRootRoles() {
		return Roles.ADMIN;
	}
	
	public static Roles getAdminRoles() {
		return Roles.ADMIN;
	}
}
