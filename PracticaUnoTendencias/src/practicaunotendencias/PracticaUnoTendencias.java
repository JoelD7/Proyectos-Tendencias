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

    static Scanner in = new Scanner(System.in);
    static String studentFile;
    static String topicsFile;
    static String groupSize;
    static GroupAssigner groupAssigner;
    static boolean invalidFileNames = false;

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        do {
            getUserInput();
            while (true) {
                try {
                    groupAssigner = new GroupAssigner(studentFile, topicsFile);
                    break;
                } catch (IOException e) {
                    System.out.println("Uno o ambos de los archivos indicados "
                            + "no se encontraron.");
                    System.out.println("Por favor intente de nuevo");
                    System.out.println("\n---------------------------------\n");
                    getUserInput();
                }
            }
        } while (groupAssigner.hasInvalidFields(groupSize));

        List<Group> groups = groupAssigner.groupDivider();
        int i = 1;
        for (Group g : groups) {
            System.out.printf("\nGRUPO #%d:\n", i);
            System.out.println("Miembros: " + g.getStudents());
            System.out.println("Temas: " + g.getTopics());
            i++;
        }
    }

    public static void getUserInput() {
        System.out.print("Nombre archivo estudiantes: ");
        studentFile = in.nextLine();

        System.out.print("Nombre archivo temas: ");
        topicsFile = in.nextLine();

        System.out.print("Tamaño de grupo: ");
        groupSize = in.nextLine();
    }

}
