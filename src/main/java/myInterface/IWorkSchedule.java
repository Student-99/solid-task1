package myInterface;

public interface IWorkSchedule {
    public String getWorkSchedule();

    public IWorkSchedule setWorkScheduleInDayOfWeek(int dayOfWeek, String workSchedule);
}
