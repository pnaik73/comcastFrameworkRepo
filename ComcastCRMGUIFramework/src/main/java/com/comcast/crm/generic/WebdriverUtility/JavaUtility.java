package com.comcast.crm.generic.WebdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public  int getRandonNumber () {
		Random random=new Random();
		int rannum=random.nextInt(1000);
		return rannum;
	}
	
	public String getSystemDateyyyyMMdd() {
		Date dt=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dt);
		return date;
	}
	
	public String getRequiredDateYYYYMMDD(int days) {
		Date dt=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dt);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqdate = sim.format(cal.getTime());
		return 	reqdate;
	}
}
