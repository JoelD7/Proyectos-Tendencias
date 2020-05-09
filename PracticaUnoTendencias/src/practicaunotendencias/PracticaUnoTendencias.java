package practicaunotendencias;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticaUnoTendencias {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Scanner in = new Scanner(System.in);
        String studentFile;
        String topicsFile;
        int groupSize;
        GroupAssigner groupAssigner;

        do {
            System.out.print("Nombre archivo estudiantes: ");
            studentFile = in.nextLine();

            System.out.print("Nombre archivo temas: ");
            topicsFile = in.nextLine();

            System.out.print("Tamaño de grupo: ");
            groupSize = in.nextInt();
            in.nextLine();
            groupAssigner = new GroupAssigner(studentFile, topicsFile, groupSize);
        } while (groupAssigner.hasInvalidFields());

        List<Group> groups = groupAssigner.groupDivider();
        int i = 1;
        for (Group g : groups) {
            System.out.printf("\nGRUPO #%d:\n", i);
            System.out.println("Miembros: " + g.getStudents());
            System.out.println("Temas: " + g.getTopics());
            i++;
        }

    }

}
