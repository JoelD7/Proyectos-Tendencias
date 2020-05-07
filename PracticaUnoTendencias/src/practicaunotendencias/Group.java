package practicaunotendencias;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<String> topics;
    private List<String> students;
    //Indica si el grupo tiene un estudiante adicional a la cantidad base. 
    private boolean hasStudentRemainder = false;
    //Indica si el grupo tiene un tema adicional a la cantidad base. 
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
