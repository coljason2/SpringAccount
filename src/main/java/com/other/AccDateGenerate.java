package com.other;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class AccDateGenerate {

	List<String> year = new ArrayList<String>();;
	List<String> day = new ArrayList<String>();

	public List<String> getYear() {
		int y = YearMonth.now().getYear();
		year.add((y - 1) + "");
		year.add(y + "");
		year.add((y + 1) + "");
		return year;
	}

	public List<String> getDay() {

		for (int i = 1; i <= 12; i++) {
			if (i >= 10)
				this.day.add(i + "");
			else
				this.day.add("0" + i);
		}

		return this.day;
	}

}
