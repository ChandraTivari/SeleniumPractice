package com.crm.qa.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RoughWork {

	public static void main(String[] args) {


		SimpleDateFormat format=new SimpleDateFormat("dd-MM-YYYY hhmm");

		Date date=new Date();
		
		System.out.println(date);
		format.format(date);

		System.out.println(format.format(date));
	}

}
