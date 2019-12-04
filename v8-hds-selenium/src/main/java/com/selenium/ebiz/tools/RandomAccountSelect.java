package com.selenium.ebiz.tools;

import java.util.Stack;

public class RandomAccountSelect {

	private ConfigFileRead configRead;

	public static Stack<String>
	users = new Stack<>();

	static{
		//	users.push("automation_id_31");  //delivery date not displays on SC for added product
		/*users.push("automation_id_33");
		users.push("automation_id_34");
		users.push("automation_id_35");
		users.push("automation_id_36");
		users.push("automation_id_37");
		users.push("automation_id_38");
		users.push("automation_id_39");
		users.push("automation_id_40");*/
		users.push("loadtest10001");
		users.push("loadtest10002");
		users.push("loadtest10003");
		users.push("loadtest10004");
		users.push("loadtest10005");
		users.push("loadtest10006");
		users.push("loadtest10007");
		users.push("loadtest10008");
		users.push("loadtest10009");
		users.push("loadtest10010");
		users.push("loadtest10011");
		users.push("loadtest10012");
		users.push("loadtest10013");
		users.push("loadtest10014");
		users.push("loadtest10015");
		users.push("loadtest10016");
		users.push("loadtest10017");
		users.push("loadtest10018");
		users.push("loadtest10019");
		users.push("loadtest10020");
		users.push("loadtest10021");
		users.push("loadtest10022");
		users.push("loadtest10023");
		users.push("loadtest10024");
		users.push("loadtest10025");
		users.push("loadtest10026");
		users.push("loadtest10027");
		users.push("loadtest10028");
		users.push("loadtest10029");
		users.push("loadtest10030");
		users.push("loadtest10031");
		users.push("loadtest10032");
		users.push("loadtest10033");
		users.push("loadtest10034");
		users.push("loadtest10035");
		users.push("loadtest10036");
		users.push("loadtest10037");
		users.push("loadtest10038");
		users.push("loadtest10039");
		users.push("loadtest10040");
		users.push("loadtest10041");
		users.push("loadtest10042");
		users.push("loadtest10043");
		users.push("loadtest10044");
		users.push("loadtest10045");
		users.push("loadtest10046");
		users.push("loadtest10047");
		users.push("loadtest10048");
		users.push("loadtest10049");
		users.push("loadtest10050");
		users.push("loadtest10051");
		users.push("loadtest10052");
		users.push("loadtest10053");
		users.push("loadtest10054");
		users.push("loadtest10055");
		users.push("loadtest10056");
		users.push("loadtest10057");
		users.push("loadtest10058");
		users.push("loadtest10059");
		users.push("loadtest10060");
    	users.push("loadtest10061");
		users.push("loadtest10062");
		users.push("loadtest10063");
		users.push("loadtest10064");
		users.push("loadtest10065");
		users.push("loadtest10066");
		users.push("loadtest10067");
		users.push("loadtest10068");
		users.push("loadtest10069");
		users.push("loadtest10070");
		users.push("loadtest10071");
		users.push("loadtest10072");
		users.push("loadtest10073");
		users.push("loadtest10074");
		users.push("loadtest10075");
		users.push("loadtest10076");
		users.push("loadtest10077");
		users.push("loadtest10078");
		users.push("loadtest10079");
		users.push("loadtest10080");
		users.push("loadtest10081");
		users.push("loadtest10082");
		users.push("loadtest10083");
		users.push("loadtest10084");
		users.push("loadtest10085");
		users.push("loadtest10086");
		users.push("loadtest10087");
		users.push("loadtest10088");
		//users.push("loadtest10089"); //part number 111354 not shipable for default address with this account
		users.push("loadtest10090");
		users.push("automation_id_26");
	/*	users.push("automation_id_27");
		users.push("automation_id_28");
		users.push("automation_id_29");
		users.push("automation_id_30");
		users.push("automation_id_32");
	*/

	}

	public static Stack<String>
	devusers = new Stack<>();
	static{

		//devusers.push("prd_wchoi_43");
		//devusers.push("julyrelease"); - tax is not avail
		// devusers.push("oloza353"); - perment disabled
		// devusers.push("debtig");
		devusers.push("loadtest10001");
		devusers.push("loadtest10004");
		devusers.push("loadtest10002");
		devusers.push("loadtest10003");
		devusers.push("loadtest10015");
	//	devusers.push("chills");
		devusers.push("nate40");
		// - charge my account option is disabled after DB refresh
	}

	public static Stack<String>
	sumausers = new Stack<>();
	static{

		sumausers.push("ranchodelnorte");
		sumausers.push("greenwoodterrace");
		//sumausers.push("str_006");
		sumausers.push("avpatel1953");
		//sumausers.push("jlprop");
		sumausers.push("dpboos");
		//sumausers.push("southseattle");
		//sumausers.push("kastner");
		sumausers.push("jacksonjr");
		sumausers.push("mvalentine");
		sumausers.push("unclepook");
		sumausers.push("steve.dadson");
		//sumausers.push("cporter1");
		//sumausers.push("andreastsitos");
		sumausers.push("mspavalon");
		//sumausers.push("drnold24");
		//sumausers.push("laurievanallen");
		//sumausers.push("bayvista854");
		sumausers.push("redroof662");
		sumausers.push("lwoodapts");
		//sumausers.push("kbrophy");
	}
	
	public static Stack<String>
	obousers = new Stack<>();
	static
	{
        obousers.push("leon.palo@hdsupply.com");
		obousers.push("ronald.parks@hdsupply.com");
	}

	public static Stack<String>
	ebizSupportusers = new Stack<>();
	static
	{
		ebizSupportusers.push("Chandrasekhar.Geddam@hdsupply.com");
		ebizSupportusers.push("ruben.leal2@hdsupply.com");
		
	}

	public static Stack<String>
			avendraUser = new Stack<>();
	static
	{

		avendraUser.push("brandyburke");
		avendraUser.push("shortie");
	}
	
}
