package practicaunotendencias;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAssigner {

    // Students per group
    private int groupSize;
    private int groupAmount;
    // Topics per group
    private int topicsPerGroup;
    private List<Group> groups;
    private List<String> students;
    private List<String> topics;

    public GroupAssigner(String studentFile, String topicsFile) throws IOException {
        students = new ArrayList<>();
        topics = new ArrayList<>();
        groups = new ArrayList<>();

        /*
         * Reads two files and creates two lists with their contents: one
         * of students and other of topics.
         */
        try (Stream<String> linesStudents = Files.lines(Paths.get(studentFile));
                Stream<String> linesTopics = Files.lines(Paths.get(topicsFile))) {
            students = linesStudents.collect(Collectors.toList());
            topics = linesTopics
                    .map(line -> line.trim())
                    .collect(Collectors.toList());

        }
    }

    public boolean hasInvalidFields(String groupSizeInput) {
        return isGroupSizeInvalid(groupSizeInput) || areTopicsQuantInvalid();
    }

    private boolean isGroupSizeInvalid(String groupSizeInput) {
        int groupSize;

        try {
            groupSize = Integer.parseInt(groupSizeInput);
        }
            catch (NumberFormatException e)
        {
            System.out.println("Error! El tamaño del grupo dado no es un número entero\n");
            System.out.println("Por favor intente de nuevo\n");
            System.out.println("\n---------------------------------\n");
            return true;
        }

        this.groupSize = groupSize;

        if (students.size() < groupSize) {
            System.out.printf("Error! El tamaño del grupo(%d) es mayor a la cantidad "
                    + "total de estudiantes(%d)\n", groupSize, students.size());
            System.out.println("Por favor intente de nuevo\n");
            System.out.println("\n---------------------------------\n");
            return true;
        }
        if (groupSize <= 0) {
            System.out.println("Error! El tamaño del grupo debe ser mayor a 0.");
            System.out.println("Por favor intente de nuevo\n");
            System.out.println("\n---------------------------------\n");
            return true;
        }
        return false;
    }

    private boolean areTopicsQuantInvalid() {
        if (topics.size() < groupAmount) {
            System.out.printf("Error! La cantidad de temas(%d) es menor a la "
                    + "cantidad de grupos(%d).\n", topics.size(), groupAmount);
            System.out.println("Por favor intente de nuevo\n");
            System.out.println("\n---------------------------------\n");
            return true;
        }
        return false;
    }

    public List<Group> groupDivider() {
        groupAmount = students.size() / groupSize;
        topicsPerGroup = topics.size() / groupAmount;

        for (int i = 0; i < groupAmount; i++) {
            Group g = new Group();

            assignStudentsToGroup(g);
            assignTopicsToGroup(g);
            groups.add(g);
        }

        int remainderStudents = students.size() % groupSize;
        if (remainderStudents > 0) {
            assignRemainderStudentToGroup(remainderStudents);
        }

        int remainderTopics = topics.size() % topicsPerGroup;
        if (remainderTopics > 0) {
            assignRemainderTopicToGroup(remainderTopics);
        }
        return groups;
    }

    /**
     * Of the students list, takes one randomly and adds it to the
     * group. Once that student is added, the student is deleted of the list
     * to prevent it from being added to many groups.
     *
     * @param group
     */
    public void assignStudentsToGroup(Group group) {
        if (group.getStudents().size() == groupSize
                && group.getHasStudentRemainder() == true) {
            return;
        }
        Random r = new Random();
        for (int j = 0; j < groupSize; j++) {
            int pos = r.nextInt(students.size());
            String student = students.get(pos);
            group.getStudents().add(student);
            students.remove(pos);
        }
    }

    /**
     * Of the topics list, takes one randomly and adds it to the
     * group. Once that topic is added, the topic is deleted of the list
     * to prevent it from being added to many groups.
     *
     * @param group
     */
    public void assignTopicsToGroup(Group group) {
        if (group.getTopics().size() == topicsPerGroup
                && group.getHasTopicRemainder()) {
            return;
        }

        Random r = new Random();
        for (int j = 0; j < topicsPerGroup; j++) {
            int pos = r.nextInt(topics.size());
            String topic = topics.get(pos);
            group.getTopics().add(topic);
            topics.remove(pos);
        }
    }

    /**
     * Iterates over the remainder to group them in a random
     * group.
     *
     * @param remainderStudents
     */
    public void assignRemainderStudentToGroup(int remainderStudents) {
        for (int i = 0; i < remainderStudents; i++) {
            Random r = new Random();

            int groupToAddRemainder = r.nextInt(groups.size());
            Group g = groups.get(groupToAddRemainder);

            while (g.getHasStudentRemainder()) {
                groupToAddRemainder = r.nextInt(groups.size());
                g = groups.get(groupToAddRemainder);
            }

            int studentToAdd = r.nextInt(students.size());
            String student = students.get(studentToAdd);
            g.getStudents().add(student);
            /*
             * When the remainder student is added to the given group, needs to be specified
             * this group already contains a remainder student to prevent
             * an unbalance, for example, a group having 7 students and other
             * just 5.
             */
            g.setHasStudentRemainder(true);

            students.remove(studentToAdd);
        }
    }

    public void assignRemainderTopicToGroup(int remainderTopics) {
        for (int i = 0; i < remainderTopics; i++) {
            Random r = new Random();

            int groupToAddRemainder = r.nextInt(groups.size());
            Group g = groups.get(groupToAddRemainder);

            while (g.getHasTopicRemainder()) {
                groupToAddRemainder = r.nextInt(groups.size());
                g = groups.get(groupToAddRemainder);
            }

            int topicToAdd = r.nextInt(topics.size());
            String topic = topics.get(topicToAdd);
            g.getTopics().add(topic);
            g.setHasTopicRemainder(true);

            topics.remove(topicToAdd);
        }
    }

}
