import java.util.Scanner;

public class Pratice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float[] temperature = new float[12];
        String[] months = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        float averageTemperature = 0;

        for (int i = 0; i < temperature.length; i++) {
            System.out.printf("Insirá a temperatura de %s : ",months[i]);
            temperature[i] = input.nextFloat();
            averageTemperature += temperature[i];
        }

        for (int i = 0; i < temperature.length; i++) {
            System.out.printf("A temperatura de %s é de %.1fºC\n", months[i],temperature[i]);
        }

        averageTemperature /= temperature.length;

        System.out.printf("\nA média de temperatura do ano é de %.2fºC\n", averageTemperature);
    }
}
