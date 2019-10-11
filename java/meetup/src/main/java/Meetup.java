import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

class Meetup {
    private final int month;
    private final int year;

    Meetup(int month, int year) {
        this.month = month;
        this.year = year;
    }

    LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule meetupSchedule) {
        TemporalAdjuster adjuster = null;

        switch (meetupSchedule) {
            case FIRST:
                adjuster = TemporalAdjusters.dayOfWeekInMonth(1, dayOfWeek);
                break;
            case SECOND:
                adjuster = TemporalAdjusters.dayOfWeekInMonth(2, dayOfWeek);
                break;
            case THIRD:
                adjuster = TemporalAdjusters.dayOfWeekInMonth(3, dayOfWeek);
                break;
            case FOURTH:
                adjuster = TemporalAdjusters.dayOfWeekInMonth(4, dayOfWeek);
                break;
            case LAST:
                adjuster = TemporalAdjusters.lastInMonth(dayOfWeek);
                break;
            case TEENTH:
                adjuster = TemporalAdjusters.nextOrSame(dayOfWeek);
                break;
        }

        LocalDate firstTeenthInMonthAndYear = LocalDate.of(this.year, this.month, 13);
        return firstTeenthInMonthAndYear.with(adjuster);
    }
}