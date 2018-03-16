package com.other;

import java.util.Calendar;
import java.util.Random;

public class OIDCreater {
	final static String prex = "OID";
	final static String item = "ITEM";
	String oid;
	Calendar cal = Calendar.getInstance();
	Random random = new Random();

	public String getOid() {
		Long now = cal.getTime().getTime();
		oid = prex + now;
		return oid;
	}

	public String getItemOid() {
		Long now = cal.getTime().getTime() + random.nextInt();

		oid = prex + item + now;

		return oid;
	}
}
