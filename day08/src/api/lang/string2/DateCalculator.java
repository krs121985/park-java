package api.lang.string2;

public class DateCalculator {
	public static String createRegexp(String date) {
		String yearStr = date.substring(0, 4);
		int year = Integer.parseInt(yearStr);
		
		boolean leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
		
		String monthStr = date.substring(5, 7);
		int month = Integer.parseInt(monthStr);
		
		switch(month) {
		case 2:
			if(leap) {
				return "^(19[0-9]{2}|20[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-9])$";
			}
			else {
				return "^(19[0-9]{2}|20[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8])$";
			}
		case 4,6,9,11:
			return "^(19[0-9]{2}|20[0-9]{2})-(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)$";
		default:
			return "^(19[0-9]{2}|20[0-9]{2})-(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])$";
		}
	}
}
