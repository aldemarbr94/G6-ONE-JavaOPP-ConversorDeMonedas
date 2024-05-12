import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Scanner lectura = new Scanner(System.in);

        try {

            String opcionMoneda = "1";

            while ( !opcionMoneda.equals("7") && (opcionMoneda.equals("1") | opcionMoneda.equals("2") | opcionMoneda.equals("3") |
                    opcionMoneda.equals("4") | opcionMoneda.equals("5") | opcionMoneda.equals("6") ) ) {

                System.out.println("\n****************************************************************************************\n\n" +
                        "\t|||--------------- BIENVENIDO(A) AL CONVER$OR DE MONEDA$ ---------------|||\n");

                System.out.println("\t\t\t1) Dólar estadounidense (USD) ==> Peso colombiano (COP)\n" +
                        "\t\t\t2) Peso colombiano (COP) ==> Dólar estadounidense (USD)\n" +
                        "\t\t\t3) Dólar estadounidense (USD) ==> Peso argentino (ARS)\n" +
                        "\t\t\t4) Peso argentino (ARS) ==> Dólar estadounidense (USD)\n" +
                        "\t\t\t5) Dólar estadounidense (USD) ==> Peso chileno (CLP)\n" +
                        "\t\t\t6) Peso chileno (CLP) ==> Dólar estadounidense (USD)\n" +
                        "\t\t\t7) SALIR\n" +
                        "\n****************************************************************************************\n");

                System.out.println("Por favor, elija una opción de conversión [1 al 6] o SALIR [7]: ");
                opcionMoneda = lectura.nextLine();

                if ( !opcionMoneda.equals("7") && (opcionMoneda.equals("1") | opcionMoneda.equals("2") | opcionMoneda.equals("3") |
                        opcionMoneda.equals("4") | opcionMoneda.equals("5") | opcionMoneda.equals("6") ) ){

                    System.out.println("Ingrese el valor que desea convertir: ");
                    Double cantidadConvertir = Double.valueOf(lectura.nextLine());

                    String moneda = consultaMoneda.tranformarMoneda(opcionMoneda, cantidadConvertir);

                    System.out.println("\n+=============================================================================+");
                    System.out.println(moneda);
                    System.out.println("+=============================================================================+\n");

                } else if ( !opcionMoneda.equals("1") & !opcionMoneda.equals("2") & !opcionMoneda.equals("3") &
                        !opcionMoneda.equals("4") & !opcionMoneda.equals("5") & !opcionMoneda.equals("6") & !opcionMoneda.equals("7")) {

                    System.out.println("\n***** Por favor, ingrese una opción de conversión válida [1 al 6] o SALIR [7] *****\n");
                    opcionMoneda = "1";

                }

            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\t|||--------------- ¡HA$TA PRONTO! ---------------|||\n");

    }

}
