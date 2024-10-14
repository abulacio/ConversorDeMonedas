import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tasas de conversión
        double tasaUsdToEur = 0.94;
        double tasaUsdToArs = 350;
        double tasaEurToArs = 370;

        // Menú de opciones
        System.out.println("Seleccione la moneda de origen:");
        System.out.println("1. Dólares (USD)");
        System.out.println("2. Euros (EUR)");
        System.out.println("3. Pesos Argentinos (ARS)");
        int opcionOrigen = scanner.nextInt();

        System.out.println("Seleccione la moneda de destino:");
        System.out.println("1. Dólares (USD)");
        System.out.println("2. Euros (EUR)");
        System.out.println("3. Pesos Argentinos (ARS)");
        int opcionDestino = scanner.nextInt();

        // Verifica si la moneda origen es la misma que la destino
        if (opcionOrigen == opcionDestino) {
            System.out.println("Seleccionaste la misma moneda para origen y destino. Intenta de nuevo.");
            return;
        }

        // Solicitar cantidad a convertir
        System.out.println("Ingrese la cantidad a convertir:");
        double cantidad = scanner.nextDouble();

        double resultado = 0;
        String monedaOrigen = "", monedaDestino = "";

        // Lógica de conversión
        switch(opcionOrigen) {
            case 1: // De USD
                monedaOrigen = "USD";
                if (opcionDestino == 2) { // A EUR
                    resultado = cantidad * tasaUsdToEur;
                    monedaDestino = "EUR";
                } else if (opcionDestino == 3) { // A ARS
                    resultado = cantidad * tasaUsdToArs;
                    monedaDestino = "ARS";
                }
                break;
            case 2: // De EUR
                monedaOrigen = "EUR";
                if (opcionDestino == 1) { // A USD
                    resultado = cantidad / tasaUsdToEur;
                    monedaDestino = "USD";
                } else if (opcionDestino == 3) { // A ARS
                    resultado = cantidad * tasaEurToArs;
                    monedaDestino = "ARS";
                }
                break;
            case 3: // De ARS
                monedaOrigen = "ARS";
                if (opcionDestino == 1) { // A USD
                    resultado = cantidad / tasaUsdToArs;
                    monedaDestino = "USD";
                } else if (opcionDestino == 2) { // A EUR
                    resultado = cantidad / tasaEurToArs;
                    monedaDestino = "EUR";
                }
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        // Resultado
        System.out.printf("%.2f %s son %.2f %s%n", cantidad, monedaOrigen, resultado, monedaDestino);
    }
}
