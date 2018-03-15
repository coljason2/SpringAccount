package com.other;

import java.util.Calendar;

public class OIDCreater {
	final static String prex = "OID";
	final static String item = "ITEM";
	String oid;
	Calendar cal = Calendar.getInstance();

	public String getOid() {
		Long now = cal.getTime().getTime();
		oid = prex + now;
		return oid;
	}

	public String getItemOid() {
		Long now = cal.getTime().getTime();
		oid = prex + item + now;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return oid;
	}
}
