public class Deadline extends Task {
    protected String ddate;

    public Deadline(String description, String ddate){
        super(description);
        this.ddate = ddate;
    }

    public Deadline(String description, boolean isTaskDone, String ddate) {
        super(description, isTaskDone);
        this.ddate = ddate;
    }

    public String getDescription(){
        return "[D]" + super.getDescription() + " (by: " + ddate + ")";
    }
}
