package com.web.ulit;

import java.util.Calendar;

public class OIDCreater {
	final static String prex = "OID";
	String oid;
	Calendar cal = Calendar.getInstance();

	public String getOid() {
		Long now = cal.getTime().getTime();
		oid = prex + now;
		return oid;
	}
}
