package duke.task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Event extends Task {
    protected LocalDate eventDate;
    private DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("ddMMyyyy");
    private DateTimeFormatter printFormat = DateTimeFormatter.ofPattern("dd MMM");

    public Event(String description, String eventDate){
        super(description);
        this.eventDate = LocalDate.from(parseFormat.parse(eventDate));

    }
    public Event(String description, boolean isTaskDone, String eventDate) {
        super(description, isTaskDone);
        this.eventDate = LocalDate.from(parseFormat.parse(eventDate));
    }
    @Override
    public String getTask(){
        return "[E]" + super.getTask() + " (at: " + this.eventDate.format(printFormat) + ")";
    }
    @Override
    public String toString(){
        return "[E]" + super.toString() + " (at: " + this.eventDate.format(printFormat) + ")";
    }
}
