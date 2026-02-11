package time;

public class HolidayChecker {
	//공휴일 명단을 작성(직접)
	private String[] holidays = new String[] {
		"01-01", "03-01", "05-05", "06-06", "08-15", "10-03", "10-09", "12-25"
	};
	public boolean isHoliday(String date) {
		for(int i=0; i < holidays.length; i++) {
			if(holidays[i].equals(date)) {
				return true;//찾으면 true
			}
		}
		return false;//못찾으면 false
	}
}
