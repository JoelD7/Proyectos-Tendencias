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

    //Estudiantes por grupo
    private int groupSize;
    private int groupAmount;
    //Temas por grupo
    private int topicsPerGroup;
    private List<Group> groups;
    private List<String> students;
    private List<String> topics;

    public GroupAssigner(String studentFile, String topicsFile, int groupSize) {
        this.groupSize = groupSize;

        students = new ArrayList<>();
        topics = new ArrayList<>();
        groups = new ArrayList<>();

        /*
         * Lee los dos archivos y crea dos listas con el contenido de ellos: una
         * de estudiantes y otra con los temas.
         */
        try (Stream<String> linesStudents = Files.lines(Paths.get(studentFile));
                Stream<String> linesTopics = Files.lines(Paths.get(topicsFile))) {
            students = linesStudents.collect(Collectors.toList());
            topics = linesTopics
                    .map(line -> line.trim())
                    .collect(Collectors.toList());

        } catch (IOException e) {
        }

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
     * De la lista de estudiantes, toma uno de ellos al azar y lo agrega al
     * grupo.Una vez dicho estudiante es agregado, este es eliminado de la lista
     * para evitar que sea agregado a varios grupos.
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
     * De la lista de temas, toma uno de ellos al azar y lo agrega al grupo. Una
     * vez dicho tema es agregado, este es eliminado de la lista para evitar que
     * sea agregado a varios grupos.
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
     * Itera sobre el remanente de estudiantes para agregarlos a un grupo
     * aleatorio.
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
             * Al agregar el estudiante remanente al grupo dado, debe indicarse
             * que este grupo ya contiene un estudiante remanente para prevenir
             * un desbalance, es decir, que un grupo tenga 7 estudiantes y que
             * otro tenga 5, por ejemplo.
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
