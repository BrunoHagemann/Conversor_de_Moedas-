import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaCambio consultaCambio = new ConsultaCambio();
        int busca = 0;

        while (busca != 7) {
            System.out.println("""
                    
                    Calculadora de conversor de Moedas
                    Digite a opção:

                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileiro
                    4) Real brasileiro =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Dólar =>> Boliviano boliviano
                    8) Boliviano boliviano =>> Dólar
                    9) Dólar =>> Peso chileno
                    10) Peso chileno =>> Dolar
                    11) Dólar =>> Euro
                    12) Euro =>> Euro
                    -1) sair
                    
                    Escolha uma opção válida:
                    """);

            busca = leitura.nextInt();

            if (busca >= 1 && busca <= 12) {
                System.out.print("Digite o valor: ");
                double valor = leitura.nextDouble();
                double resultado = 0;

                switch (busca) {
                    case 1 -> resultado = consultaCambio.converter("ARS", valor);
                    case 2 -> resultado = valor / consultaCambio.converter("ARS", 1);
                    case 3 -> resultado = consultaCambio.converter("BRL", valor);
                    case 4 -> resultado = valor / consultaCambio.converter("BRL", 1);
                    case 5 -> resultado = consultaCambio.converter("COP", valor);
                    case 6 -> resultado = valor / consultaCambio.converter("COP", 1);
                    case 7 -> resultado = consultaCambio.converter("BOB" , valor);
                    case 8 -> resultado = valor / consultaCambio.converter("BOB" , 1);
                    case 9 -> resultado = consultaCambio.converter("CLP",valor);
                    case 10 -> resultado = valor / consultaCambio.converter("CLP",1);
                    case 11 -> resultado = consultaCambio.converter("EUR",valor);
                    case 12 -> resultado = valor / consultaCambio.converter("EUR",1);
                }

                System.out.printf("Resultado: " + resultado);
            } else if (busca == -1) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida.");
            }
        }

        leitura.close();
    }
}