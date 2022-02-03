public class Event extends Task{
    protected String edate;

    public Event(String description, String edate){
        super(description);
        this.edate = edate;
    }
    public Event(String description, boolean isTaskDone, String edate) {
        super(description, isTaskDone);
        this.edate = edate;
    }
    public String getDescription(){
        return "[E]" + super.getDescription() + " (by: " + edate + ")";
    }

}
