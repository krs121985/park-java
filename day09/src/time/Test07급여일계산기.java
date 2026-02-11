package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test07급여일계산기 {
	public static void main(String[] args) {
		int day = 5;
		int years = 2;

		LocalDate today = LocalDate.now();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("y년 M월 d일 (E)");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MM-dd");
		HolidayChecker checker = new HolidayChecker();

		for (long i = 1L; i <= years * 12L; i++) {
			LocalDate target = today.plusMonths(i).withDayOfMonth(day);

			System.out.print(i + "회차 급여일 : " + target.format(fmt));

			// target이 주말일 경우 날짜 변경이 필요 (토요일이면 -1일, 일요일 -2일)
			if (target.getDayOfWeek() == DayOfWeek.SATURDAY) {
				target = target.minusDays(1L);
				System.out.print(" → " + target.format(fmt));
			} else if (target.getDayOfWeek() == DayOfWeek.SUNDAY) {
				target = target.minusDays(2L);
				System.out.print(" → " + target.format(fmt));
			}

			// 모든 처리가 끝나고 확인해봤을 때 법정공휴일이면 추가 날짜 조정
			if (checker.isHoliday(target.format(fmt2))) {
				target = target.minusDays(1L);
				System.out.print(" → " + target.format(fmt));
			}

			System.out.println();

		}

	}
}
