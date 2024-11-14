import java.util.Scanner;


public class Notas {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        int numberOfStudents = 4;
        float[] studentsGrade = new float[numberOfStudents];
        float anualGrade;
        float finalExam;
        int numberOfAcceptedStudents = 0, numberOfRejectedStudents = 0;

        System.out.print("Insira o número de estudantes que deseja: ");
        numberOfStudents = input.nextInt();

        for (int i = 0; i < studentsGrade.length; i++) {
            do {
                System.out.printf("Insira a nota anual do %dº aluno: ",i+1);
                anualGrade = input.nextFloat();
                if (anualGrade < 0 || anualGrade > 20) {
                    System.out.println("Dados inválidos!!\nInsira novamente");
                }
            } while(anualGrade < 0 || anualGrade > 20);

            do {
                System.out.printf("Insira a nota do exame final do %dº aluno: ",i+1);
                finalExam = input.nextFloat();
                if (finalExam < 0 || finalExam > 20) {
                    System.out.println("Dados inválidos!!\nInsira novamente");
                }
            } while(finalExam < 0 || finalExam > 20);

            studentsGrade[i] = anualGrade*0.4f + finalExam*0.6f;



            if(studentsGrade[i] >= 9.5) {
                numberOfAcceptedStudents++;
            } else {
                numberOfRejectedStudents++;
            }
        }

        for(int i = 0; i < studentsGrade.length; i++) {
            if(studentsGrade[i] >= 9.5) {
                System.out.printf("| %d Estudante | Média %.1f | Status %s\n",i+1,studentsGrade[i],"Aprovado");
            } else {
                System.out.printf("| %d Estudante | Média %.1f | Status %s\n",i+1,studentsGrade[i],"Reprovado");
            }
        }
        System.out.printf("O número de estudantes aptos: %d\n", numberOfAcceptedStudents);
        System.out.printf("O número de estudantes não aptos: %d\n", numberOfRejectedStudents);
    }
}
