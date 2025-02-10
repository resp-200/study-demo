package date;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @Description
 * @Author Zhang hao yu
 * @Date 2025/2/5 16:20
 */
public class TestDate {
    @Test
    public void dateTest(){
        LocalDateTime now = LocalDateTime.of(2025,12,31, 10, 0, 0);
        int year = now.get(WeekFields.ISO.weekBasedYear());
        System.out.println(year);
        int year1 = now.getYear();
        System.out.println(year1);
        int week = now.get(WeekFields.ISO.weekOfWeekBasedYear());
        System.out.println(week);
        int weekOfYear = now.get(WeekFields.ISO.weekOfYear());
        System.out.println(weekOfYear);
        int dayOfYear = now.getDayOfYear();
        System.out.println(dayOfYear);
        int dayOfWeek = now.getDayOfWeek().ordinal();
        System.out.println(dayOfWeek);
        List<Integer> weekdayList = getWeekdayList(now.getDayOfWeek().getValue());
        System.out.println(weekdayList);
        LocalDateTime firstMondayOfYear = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstMondayOfYear);

        LocalDateTime startTimeOfThisWeek = getStartTimeOfThisWeek();
        System.out.println(startTimeOfThisWeek);
    }

    @Test
    public void dateTest2(){
        LocalDateTime now = LocalDateTime.of(2026,1,1, 10, 0, 0);
        int year = now.get(WeekFields.ISO.weekBasedYear());
        System.out.println(year);
        int year1 = now.getYear();
        System.out.println(year1);
        int week = now.get(WeekFields.ISO.weekOfWeekBasedYear());
        System.out.println(week);
        int weekOfYear = now.get(WeekFields.ISO.weekOfYear());
        System.out.println(weekOfYear);
        int dayOfYear = now.getDayOfYear();
        System.out.println(dayOfYear);
        int dayOfWeek = now.getDayOfWeek().ordinal();
        System.out.println(dayOfWeek);
        List<Integer> weekdayList = getWeekdayList(now.getDayOfWeek().getValue());
        System.out.println(weekdayList);
        LocalDateTime firstMondayOfYear = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstMondayOfYear);

        LocalDateTime startTimeOfThisWeek = getStartTimeOfThisWeek();
        System.out.println(startTimeOfThisWeek);
    }

    public static List<Integer> getWeekdayList(int curWeekday) {
        List<Integer> weekdayList = Lists.newArrayList();
        for (int i = curWeekday; i <= 7; i++) {
            weekdayList.add(i);
        }

        return weekdayList;
    }

    public static Date getStartDateOfThisWeek() {
        Calendar cal=Calendar.getInstance();
        Date date = new Date(1735696800000L);
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    public static LocalDateTime getStartTimeOfThisWeek() {
        return dateToLocalDateTime(getStartDateOfThisWeek());
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


    @Test
    public void dateTest3(){
        LocalDateTime now = LocalDateTime.of(2024,12,23, 9,30,0);
        int weekBasedYear = now.get(WeekFields.ISO.weekBasedYear());
        System.out.println("weekBasedYear=" + weekBasedYear);
        int weekOfWeekBasedYear = now.get(WeekFields.ISO.weekOfWeekBasedYear());
        System.out.println("weekOfWeekBasedYear=" + weekOfWeekBasedYear);

//        LocalDate localDate = LocalDate.of(2024,1,1);
//        int weekBasedYear2 = localDate.get(WeekFields.ISO.weekBasedYear());
//        System.out.println("weekBasedYear2=" + weekBasedYear2);
//        int weekOfWeekBasedYear2 = localDate.get(WeekFields.ISO.weekOfWeekBasedYear());
//        System.out.println("weekOfWeekBasedYear2=" + weekOfWeekBasedYear2);
//        System.out.println("dayOfWeek=" + localDate.getDayOfWeek().getValue());
    }

    @Test
    public void test4(){
        String startDayByBasedYearWeekNumber = getStartDayByBasedYearWeekNumber2(2024, 52);
        System.out.println(startDayByBasedYearWeekNumber);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd");
        LocalDate now = LocalDate.of(2025,2,17);
        String format = now.with(DayOfWeek.TUESDAY).format(fmt);
        System.out.println(format);
    }

    public static String getStartDayByBasedYearWeekNumber(int year, int weekNo) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +
                cal.get(Calendar.DAY_OF_MONTH);
    }

    private static Date add(Date date, int calendarField, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    public static String getStartDayByBasedYearWeekNumber2(int year, int week) {
        WeekFields weekFields = WeekFields.ISO;
        // 获取该年第一天的日期
        LocalDate firstDayOfYear = LocalDate.of(year, 1, 1);
        int calcYear = firstDayOfYear.get(weekFields.weekBasedYear());

        // 根据周基年计算可能存在计算出来的年份小于当前年份，那么获取本年第一周需要往后推一周
        if (year > calcYear) {
            firstDayOfYear = firstDayOfYear.plusDays(7);
        }
        // 找到该年第一个周的周一
        LocalDate firstMonday = firstDayOfYear.with(weekFields.weekOfYear(), 1).with(weekFields.dayOfWeek(), 1);

        // 计算所需周的周一
        LocalDate mondayOfWeek = firstMonday.plusWeeks(week - 1);
        return mondayOfWeek.toString();
    }



}
