import java.util.Scanner;

// Criação de um construtor denominado por província
class Province{
    String provinceID;
    int passengerVehicles;
    int trafficAccidents;
}

public class ProvinceStatistics {
    public static final int numberOfProvince = 5;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Criado um array de províncias cuja quantidade é definida pela constante numberOfProvince
        Province[] province = new Province[numberOfProvince];

        float averageNumberOfVehicles = 0;
        int lowestTrafficAccidentRate=0, highestTrafficAccidentRate=0, trafficAccidentRate=0;
        String provinceWithLTAR = " ", provinceWithHTAR = " ";
        float averageTrafficAccidents = 0;


        for (int i = 0; i < numberOfProvince; i++) {
            province[i] = new Province(); // Instanciando um novo objecto a cada interação do loop antes de fazer as atribuições

            System.out.printf("\n\t\t%dª Província \n", i + 1);

            System.out.print("Insira o código da pronvíncia: ");
            province[i].provinceID = input.next();

            do {
                System.out.print("Insira o número de veículos de passeio na província: ");
                province[i].passengerVehicles = input.nextInt();
                if(province[i].passengerVehicles < 0){
                    System.out.print("Valor inserido inválido!!\nVolte a inserir novamente\n\n");
                }
            }while(province[i].passengerVehicles < 0);

            do {
                System.out.print("Insira o número de acidentes de trânsito com vítimas na província: ");
                province[i].trafficAccidents = input.nextInt();
                if(province[i].trafficAccidents < 0){
                    System.out.print("Valor inserido inválido!!\nVolte a inserir novamente\n\n");
                }
            }while(province[i].trafficAccidents < 0);
        }

        for (int i = 0; i < numberOfProvince; i++) {
            if(province[0].trafficAccidents < province[i].trafficAccidents){
                lowestTrafficAccidentRate = province[0].trafficAccidents;
                provinceWithLTAR = province[0].provinceID;
            }else {
                lowestTrafficAccidentRate = province[i].trafficAccidents;
                provinceWithLTAR = province[i].provinceID;
            }

            if(province[i].trafficAccidents > province[0].trafficAccidents){
                highestTrafficAccidentRate = province[i].trafficAccidents;
                provinceWithHTAR = province[i].provinceID;
            }else {
                highestTrafficAccidentRate = province[0].trafficAccidents;
                provinceWithHTAR = province[0].provinceID;
            }

            averageNumberOfVehicles += province[i].passengerVehicles;

            if(province[i].passengerVehicles < 2000){
                averageTrafficAccidents += province[i].trafficAccidents;
                trafficAccidentRate += 1;
            }
        }

        averageNumberOfVehicles = averageNumberOfVehicles / numberOfProvince;
        averageTrafficAccidents = averageTrafficAccidents / trafficAccidentRate;

        System.out.printf("\nO maior índice de acidentes de transito é de %d da província %s",highestTrafficAccidentRate,provinceWithHTAR);
        System.out.printf("\nO menor índice de acidentes de transito é de %d da província %s",lowestTrafficAccidentRate,provinceWithLTAR);
        System.out.printf("\nA média de veículos nas cinco províncias juntas é de: %.2f",averageNumberOfVehicles);
        System.out.printf("\nA média de acidentes de trânsito nas cidades com menos de 2000 veículos de passeio é de %.2f", averageTrafficAccidents);

        input.close();
    }
}
