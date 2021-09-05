package workSchedule;

import myInterface.IWorkSchedule;

public class WorkSchedule implements IWorkSchedule {
    private static final int COUNT_OF_DAYS_IN_WEEK = 7;
    private String[] workSchedule = new String[COUNT_OF_DAYS_IN_WEEK];

    @Override
    public WorkSchedule setWorkScheduleInDayOfWeek(int dayOfWeek, String workSchedule) {
        this.workSchedule[dayOfWeek] = workSchedule;
        return this;
    }

    @Override
    public String getWorkSchedule() {
        for (int i = 0; i < COUNT_OF_DAYS_IN_WEEK; i++) {

            if (workSchedule[i] == null) {
                workSchedule[i] = "Выходной";
            }
            workSchedule[i] += i + " день недели ";
        }
        return String.format("График работы:\n %s", workSchedule.toString());
    }

    @Override
    public String toString() {
        return getWorkSchedule();
    }
}
