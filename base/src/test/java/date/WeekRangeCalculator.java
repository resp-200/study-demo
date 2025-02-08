package date;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class WeekRangeCalculator {

    public static List<WeekRange> getWeekRanges(LocalDate startDate, LocalDate endDate) {
        List<WeekRange> weekRanges = new ArrayList<>();
        // 确保起始日期是周一
        LocalDate currentDate = startDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        while (!currentDate.isAfter(endDate)) {
            LocalDate startOfWeek = currentDate;
            LocalDate endOfWeek = currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

            // 确保结束日期不超过给定的结束日期
            if (endOfWeek.isAfter(endDate)) {
                endOfWeek = endDate;
            }

            weekRanges.add(new WeekRange(startOfWeek, endOfWeek));

            // 移动到下一周的开始
            currentDate = endOfWeek.plusDays(1).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

            // 如果当前日期已经超过了结束日期，则停止
            if (currentDate.isAfter(endDate)) {
                break;
            }
        }

        return weekRanges;
    }

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2025, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 1, 31);

        List<WeekRange> weekRanges = getWeekRanges(startDate, endDate);

        for (int i = 0; i < weekRanges.size(); i++) {
            WeekRange weekRange = weekRanges.get(i);
            System.out.println("第 " + (i + 1) + " 周: " + weekRange.getStartOfWeek() + " - " + weekRange.getEndOfWeek());
        }
    }
}

class WeekRange {
    private final LocalDate startOfWeek;
    private final LocalDate endOfWeek;

    public WeekRange(LocalDate startOfWeek, LocalDate endOfWeek) {
        this.startOfWeek = startOfWeek;
        this.endOfWeek = endOfWeek;
    }

    public LocalDate getStartOfWeek() {
        return startOfWeek;
    }

    public LocalDate getEndOfWeek() {
        return endOfWeek;
    }
}
