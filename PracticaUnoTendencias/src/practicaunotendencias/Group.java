package practicaunotendencias;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<String> topics;
    private List<String> students;
    // Indicates if the group has one more student than the base quantity. 
    private boolean hasStudentRemainder = false;
    // Indicates if the group has one more topic than the base quantity. 
    private boolean hasTopicRemainder = false;

    public Group() {
        students = new ArrayList<>();
        topics = new ArrayList<>();
    }

    public List<String> getTopics() {
        return topics;
    }

    public List<String> getStudents() {
        return students;
    }

    public boolean getHasStudentRemainder() {
        return hasStudentRemainder;
    }

    public boolean getHasTopicRemainder() {
        return hasTopicRemainder;
    }

    public void setHasStudentRemainder(boolean hasRemainder) {
        this.hasStudentRemainder = hasRemainder;
    }

    public void setHasTopicRemainder(boolean hasTopicRemainder) {
        this.hasTopicRemainder = hasTopicRemainder;
    }

    @Override
    public String toString() {
        return "";
    }

}
