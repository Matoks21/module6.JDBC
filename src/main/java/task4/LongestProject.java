package task4;


public class LongestProject {
    private final long id;
    private final long monthCount;

    public LongestProject(long id, long monthCount) {
        this.id = id;
        this.monthCount = monthCount;
    }

    public long getId() {
        return id;
    }

    public long getMonthCount() {
        return monthCount;
    }
}
