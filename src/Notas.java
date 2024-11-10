import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        float[] studentsGrade = new float[10];
        float /*averageGrade = 0*/ anualGrade, finalExam;
        int numberOfAcceptedStudents = 0;

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

           // averageGrade += studentsGrade[i];

            if(studentsGrade[i] >= 9.5) {
                numberOfAcceptedStudents++;
            }
        }

        //averageGrade /= studentsGrade.length;

        //System.out.printf("A média da turma é de: %.2f\n", averageGrade);
        for(float studentGrade: studentsGrade) {
            System.out.printf("%.2f\n",studentGrade);
        }
        System.out.printf("O número de estudantes aptos: %d\n", numberOfAcceptedStudents);
    }
}
