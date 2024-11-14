import java.util.ArrayList;
import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Float> studentsGrade = new ArrayList<>();
        float anualGrade, finalExam, grade, finalGrade;
        int numberOfStudents, numberOfAcceptedStudents = 0, numberOfRejectedStudents = 0;

        System.out.print("Insira o número de estudantes que deseja: ");
        numberOfStudents = input.nextInt();

        for (int i = 0; i < numberOfStudents; i++) {
            do {
                System.out.printf("Insira a nota anual do %dº aluno: ", i + 1);
                anualGrade = input.nextFloat();
                if (anualGrade < 0 || anualGrade > 20) {
                    System.out.println("Dados inválidos!!\nInsira novamente");
                }
            } while (anualGrade < 0 || anualGrade > 20);

            do {
                System.out.printf("Insira a nota do exame final do %dº aluno: ", i + 1);
                finalExam = input.nextFloat();
                if (finalExam < 0 || finalExam > 20) {
                    System.out.println("Dados inválidos!!\nInsira novamente");
                }
            } while (finalExam < 0 || finalExam > 20);

            finalGrade = anualGrade * 0.4f + finalExam * 0.6f;
            studentsGrade.add(finalGrade);

            if (finalGrade >= 9.5) {
                numberOfAcceptedStudents++;
            } else {
                numberOfRejectedStudents++;
            }
        }

        for (int i = 0; i < studentsGrade.size(); i++) {
            grade = studentsGrade.get(i);
            if (grade >= 9.5) {
                System.out.printf("| %dº Estudante | Média %.2f | Status %s\n", i + 1, grade, "Aprovado");
            } else {
                System.out.printf("| %dº Estudante | Média %.2f | Status %s\n", i + 1, grade, "Reprovado");
            }
        }

        System.out.printf("O número de estudantes aptos: %d\n", numberOfAcceptedStudents);
        System.out.printf("O número de estudantes não aptos: %d\n", numberOfRejectedStudents);
    }
}

