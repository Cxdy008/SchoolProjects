import java.util.Scanner;

class Operator{
    char sex;
    float salary;
    int number;
    int numberOfPartsManufactured;
}

public class SalaryCalculation {
    public static final byte numberOfOperator = 15;
    public static final float tax1 = 0.03f, tax2 = 0.05f;
    public static final float salary = 100000.0f;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Criando um vector de 15 operadores
        Operator[] operator = new Operator[numberOfOperator];

        float operatorSalaryCalculation, totalOfSalaryToPay = 0;
        int numberOfParts, totalOfPartsManufactured = 0, totalOfPartsManufacturedByMale = 0, totalOfPartsManufacturedByFemale = 0, operatorWithHighestSalary = 0;
        byte numberOfMaleOperator = 0, numberOfFemaleOperator = 0;

        for (int i = 0; i < numberOfOperator; i++) {
            operator[i] = new Operator();

            System.out.printf("\n\t\t%dª Operador \n", i + 1);
            do {
                System.out.print("Insira o sexo do operador: ");
                operator[i].sex = input.next().toUpperCase().charAt(0);
                if (operator[i].sex != 'M' && operator[i].sex != 'F'){
                    System.out.print("Valor inserido inválido!!\nVolte a inserir novamente\n\n");
                }
            }while(operator[i].sex != 'M' && operator[i].sex != 'F');

            do {
                System.out.print("Insira o número do operador: ");
                operator[i].number = input.nextInt();
                if (operator[i].number < 0){
                    System.out.print("Valor inserido inválido!!\nVolte a inserir novamente\n\n");
                }
            } while(operator[i].number < 0);

            do {
                System.out.print("Insira o número de peças fabricadas pelo operador no mês: ");
                operator[i].numberOfPartsManufactured = input.nextInt();
                if (operator[i].numberOfPartsManufactured < 0){
                    System.out.print("Valor inserido inválido!!\nVolte a inserir novamente\n\n");
                }
            } while(operator[i].numberOfPartsManufactured < 0);
        }

        for (int i = 0; i < numberOfOperator; i++) {
            if (operator[i].numberOfPartsManufactured <= 30 ) {
                operator[i].salary = salary;
            } else if (operator[i].numberOfPartsManufactured <= 50 ) {
                numberOfParts = operator[i].numberOfPartsManufactured - 30;
                operatorSalaryCalculation = salary*numberOfParts*tax1;
                operator[i].salary = salary + operatorSalaryCalculation;
            } else {
                numberOfParts = operator[i].numberOfPartsManufactured - 30;
                operatorSalaryCalculation = salary*numberOfParts*tax2;
                operator[i].salary = salary + operatorSalaryCalculation;
            }

            totalOfSalaryToPay += operator[i].salary;
            totalOfPartsManufactured += operator[i].numberOfPartsManufactured;

            if(operator[i].sex == 'M'){
                totalOfPartsManufacturedByMale += operator[i].numberOfPartsManufactured;
                numberOfMaleOperator += 1;
            } else {
                totalOfPartsManufacturedByFemale += operator[i].numberOfPartsManufactured;
                numberOfFemaleOperator += 1;
            }

            if (operator[i].salary > operator[0].salary) {
                operatorWithHighestSalary = operator[i].number;
            } else {
                operatorWithHighestSalary = operator[0].number;
            }

            System.out.printf("\n| Número do operário: %d | Salário do operário %.2f AKZ\n", operator[i].number, operator[i].salary);
        }

        System.out.printf("\nO total de pagamento da fábrica é de: %.2f AKZ\n", totalOfSalaryToPay);
        System.out.printf("O total de peças fabricadas pela pela fábrica no mês é de %d\n", totalOfPartsManufactured);
        System.out.printf("A média de peças fabricadas pelos homens é de %.2f\n",(float) totalOfPartsManufacturedByMale/numberOfMaleOperator);
        System.out.printf("A média de peças fabricadas pelas mulheres é de %.2f\n",(float) totalOfPartsManufacturedByFemale/numberOfFemaleOperator);
        System.out.printf("O número do operário(a) de maior salário é: %d", operatorWithHighestSalary);
        input.close();
    }
}
