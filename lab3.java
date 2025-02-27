import java.util.Scanner;

public class BinaryDecimalConverter {
    
    public static int binaryToDecimal(String binaryStr) {
        try {
            return Integer.parseInt(binaryStr, 2);
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada no válida. Debe ser un número binario de 8 dígitos.");
            return -1;
        }
    }
    
    public static String decimalToBinary(int decimalNum) {
        if (decimalNum < 0 || decimalNum > 255) {
            return "Error: El número debe estar entre 0 y 255.";
        }
        return String.format("%08d", Integer.parseInt(Integer.toBinaryString(decimalNum)));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opción:\n1. Binario a Decimal\n2. Decimal a Binario");
        String opcion = scanner.nextLine();
        
        if (opcion.equals("1")) {
            System.out.print("Ingrese un número binario de 8 dígitos: ");
            String binario = scanner.nextLine();
            if (binario.length() == 8 && binario.matches("[01]+")) {
                System.out.println("Decimal: " + binaryToDecimal(binario));
            } else {
                System.out.println("Error: Debe ingresar exactamente 8 dígitos binarios (0 o 1).");
            }
        } else if (opcion.equals("2")) {
            System.out.print("Ingrese un número decimal (0-255): ");
            try {
                int decimal = Integer.parseInt(scanner.nextLine());
                System.out.println("Binario: " + decimalToBinary(decimal));
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada no válida. Debe ser un número entero.");
            }
        } else {
            System.out.println("Opción no válida.");
        }
        
        scanner.close();
    }
}