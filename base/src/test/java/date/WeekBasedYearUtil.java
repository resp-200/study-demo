package date;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Calendar;

/**
 * @Description 周基年计算util
 * @Author Zhang hao yu
 * @Date 2025/2/7 16:31
 */
@Data
public class WeekBasedYearUtil {

    private static final Integer WEEK_NUM = 7;


    /** 根据周基年获取周基年周数对应的周一日期
     * @param year 周基年
     * @param week 周基年第几周
     * @return 周一日期
     */
    public static String getStartDayByBasedYearWeekNumber(int year, int week) {
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

    /** 获取周基年
     * @param localDate 年月日
     * @return 周基年
     */
    public static int getWeekBasedYear(LocalDate localDate) {
        return localDate.get(WeekFields.ISO.weekBasedYear());
    }

    /** 根据当前时间获取对应的周基年周数
     *  2024.12.31属于2025年第1周
     *  2009.12.31属于2009年第53周
     * @param currentDate 当前时间
     * @return 周基年周数
     */
    public static int getWeekNumberBasedYear(LocalDate currentDate) {
        return currentDate.get(WeekFields.ISO.weekOfWeekBasedYear());
    }

    /** 获取当前周的周基年信息
     * @return 周基年信息
     */
    public static EmployeeDutyTableDateDTO getCurrentBasedYearWeek() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd");
        LocalDate now =
//                LocalDate.now();
                LocalDate.of(2009, 12, 31);
        int dayOfWeek = now.getDayOfWeek().getValue();
        LocalDate weekStart = now.minusDays(dayOfWeek - 1);
        LocalDate weekEnd = now.plusDays(WEEK_NUM - dayOfWeek);
        return new EmployeeDutyTableDateDTO(weekStart.format(fmt) + "-" + weekEnd.format(fmt), "本周",
                WeekBasedYearUtil.getWeekBasedYear(weekStart), WeekBasedYearUtil.getWeekNumberBasedYear(weekEnd));
    }

    public static void main(String[] args) {
//        System.out.println(getCurrentBasedYearWeek());
        System.out.println(getStartDayByWeekNo(2027, 52));
        System.out.println(getStartDayByBasedYearWeekNumber(2027, 52));
    }

    public static String getStartDayByWeekNo(int year, int weekNo) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
//        if (YEAR_2025 == year) {
//            Date date = org.apache.commons.lang3.time.DateUtils.addWeeks(cal.getTime(), 1);
//            cal.setTime(date);
//        }
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +
                cal.get(Calendar.DAY_OF_MONTH);
    }

}
