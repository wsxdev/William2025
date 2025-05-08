package espoch.edu.ec.william2025;

import java.util.Scanner;

public class William2025 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Double[] litrosConsumidosPorDias = new Double[7];
        String[] dias = new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
        int opcion;

        System.out.println("INGRESO DE LITROS CONSUMIDOS POR DIAS");

        for (int i = 0; i < dias.length; i++) {
            System.out.print("Litros consumidos el dia " + dias[i] + " (Mayores a 0): ");
            litrosConsumidosPorDias[i] = entrada.nextDouble();

            while (!(litrosConsumidosPorDias[i] > 0)) {
                System.out.println("ERROR: los valores tienen que ser mayores a 0, intente de nuevo");
                System.out.print("Litros consumidos el dia " + dias[i] + ": ");
                litrosConsumidosPorDias[i] = entrada.nextDouble();
            }
        }

        Double totalLitrosConsumidosSemana = 0d;
        for (int i = 0; i < litrosConsumidosPorDias.length; i++) {
            totalLitrosConsumidosSemana += litrosConsumidosPorDias[i];
        }
        Double promedio = totalLitrosConsumidosSemana / litrosConsumidosPorDias.length;

        do {
            System.out.println("\n\nMENU PRINCIPAL");
            System.out.println("1. Total de litros consumidos en la semana");
            System.out.println("2. Dia con consumo mas cercano al promedio");
            System.out.println("3. Mostrar dia de mayor y menor consumo");
            System.out.println("4. Sumar los consumos de lunes a miercoles y de viernes a domingo");
            System.out.println("5. Salir");
            System.out.print("\nIngrese una opcion (1-5): ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1: // TOTAL DE LITROS CONSUMIDOS EN LA SEMANA

                    System.out.println("\nEl total de litros consumidos en la semana es: " + totalLitrosConsumidosSemana);
                    break;

                case 2: // DIA CONSUMO MAS CERCANO AL PROMEDIO
                    Double menorDiferencia = (litrosConsumidosPorDias[0] - promedio);
                    menorDiferencia *= -1;
                    System.out.println(menorDiferencia);
                    int diaCercano = 0;
                    
                    for (int i = 1; i < litrosConsumidosPorDias.length; i++) {
                        Double diferencia = (litrosConsumidosPorDias[i] - promedio);
                        
                        if (diferencia < menorDiferencia) {
                            menorDiferencia = -diferencia;
                            diaCercano = i;
                        }
                    }


                    System.out.println("\nEl promedio es: " + promedio);
                    System.out.println("El dia con consumo mas cercano al promedio es: " + dias[diaCercano] + " con " + litrosConsumidosPorDias[diaCercano]);
                    break;

                case 3: // MOSTRAR DIA DE MAYOR Y MENOR CONSUMO
                    Double diaMayorConsumo = litrosConsumidosPorDias[0];
                    Double diaMenorConsumo = litrosConsumidosPorDias[0];
                    int diaMayor = 0;
                    int diaMenor = 0;
                    for (int i = 1; i < litrosConsumidosPorDias.length; i++) {
                        if (litrosConsumidosPorDias[i] > diaMayorConsumo) {
                            diaMayorConsumo = litrosConsumidosPorDias[i];
                            diaMayor = i;
                        }
                        if (litrosConsumidosPorDias[i] < diaMenorConsumo) {
                            diaMenorConsumo = litrosConsumidosPorDias[i];
                            diaMenor = i;
                        }
                    }
                    System.out.println("\nEl dia de mayor consumo es: " + dias[diaMayor] + " con " + diaMayorConsumo);
                    System.out.println("El dia de menor consumo es: " + dias[diaMenor] + " con " + diaMenorConsumo);
                    break;

                case 4: // SUMA DE LOS CONSUMOS DE LUNES A MIERCOLES Y DE VIERNES A DOMINGO
                    Double sumaLunesAMiercoles = 0d;
                    Double viernesADomingo = 0d;

                    for (int i = 0; i < 3; i++) {
                        sumaLunesAMiercoles += litrosConsumidosPorDias[i];
                    }

                    for (int i = 4; i < 7; i++) {
                        viernesADomingo += litrosConsumidosPorDias[i];
                    }
                    System.out.println("\nLa suma de los consumos de Lunes a Miercoles es: " + sumaLunesAMiercoles);
                    System.out.println("La suma de los consumos de Viernes a Domingo es: " + viernesADomingo);

                    break;

                case 5: // SALIR DEL PROGRAMA
                    System.out.println("\nSaliendo del programa...");
                    break;

                default:
                    System.out.println("\nOpcion no valida, intente de nuevo");
                    break;
            }
        } while (opcion != 5);

        entrada.close();
    }
}
