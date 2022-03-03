package duke.task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Deadline extends Task {
    protected LocalDateTime dueDate;
    private DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("ddMMyyyy HHmm");
    private DateTimeFormatter printFormat = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a");


    public Deadline(String description, String dueDate){
        super(description);
        this.dueDate = LocalDateTime.from(parseFormat.parse(dueDate));
    }

    public Deadline(String description, boolean isTaskDone, String dueDate) {
        super(description, isTaskDone);
        this.dueDate = LocalDateTime.from(parseFormat.parse(dueDate));
    }
    @Override
    public String getTask(){
        return "[D]" + super.getTask() + " (by: " + this.dueDate.format(printFormat) + ")";
    }
    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + this.dueDate.format(printFormat) + ")";
    }
}
