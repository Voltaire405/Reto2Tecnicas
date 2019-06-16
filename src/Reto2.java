/*Reto 2 de Técnicas de Programación, Jose Luis Marín Arango*/

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import  java.util.Scanner;
public class Reto2 {
    public static void main(String[] args) {
        int choice;

        choice = 1;
        while(choice > 0 && choice <= 5) {
            choice = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese a continuación:\n" +
                    "1. Primer punto del Reto\n" +
                    "2. Segundo punto del Reto\n" +
                    "3. Tercer punto del Reto\n" +
                    "4. Cuarto punto del Reto\n" +
                    "5. Quinto punto del Reto\n" +
                    "0. Para salir"));//Pide al usuario que ingrese una opción.
            switch (choice){
                case 1:
                    ResolverPrimerPunto();
                    break;
                case 2:
                    ResolverSegundoPunto();
                    break;
                case 3:
                    ResolverTercerPunto();
                    break;
                case 4:
                    ResolverCuartoPunto();
                    break;
                case 5:
                    ResolverQuintoPunto();
                    break;
                default:
                    break;
            }

        }
    }

    public static void ResolverPrimerPunto(){
        int n,cuadrado,impar,count;
        String mensaje;
        cuadrado = 0;
        impar = 0;
        n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese n: "));
        for (count = 0 ;count < n; count++){
            mensaje="";
            impar = 2*count + 1;//Definición matemática de número impar.
            cuadrado += impar;
        }
        JOptionPane.showMessageDialog(null, "El cuadrado de " + n + " es " + cuadrado);
    }

    public static void ResolverSegundoPunto(){
        int n,count,total;
        n = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un entero positivo n"));
        if (n == 1){
            total = 1;
        }else {
            total = 0;
            count = n*(n-1)/2; //Fórmula de Gauss para la suma de los primeros n-1 enteros.
            for (int i = 1; i <= n; i++){
                total += 2*(count+i)-1; //Definición mat. de impar.
            }
        }
        JOptionPane.showMessageDialog(null,"El cubo de: "+n+" es "+total);
    }

    public static void ResolverTercerPunto(){
        double salaryWeekly, salary; //Salario semanal y por hora.
        int hours, surplus;//horas laboradas semanalmente y extras.
        String id; //Identificación del trabajador.

        surplus = 0;
        id = JOptionPane.showInputDialog(null,"Ingrese la identificacion del trabajador: ");
        salary = Math.abs(Double.parseDouble(JOptionPane.showInputDialog(null,
                "Ingrese el salario por hora: $")));
        hours = Math.abs(Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingrese las horas laboradas esta semana por el trabajador: ")));
        if (hours <= 48){
            salaryWeekly = hours * salary;
        }else {
            surplus = hours - 48;
            salaryWeekly = 48 * salary + surplus*(salary * 1.35);
        }
        JOptionPane.showMessageDialog(null,"El salario semanal de " + id +
        " por " + hours + " horas laboradas, es de $" + salaryWeekly );
    }

    public static void ResolverCuartoPunto(){
        int amount, oneHBill, fiftyBill, twentyBill, tenBill, fiveBill, twoBill;
        fiftyBill = 0;
        oneHBill = 0;
        twentyBill = 0;
        tenBill = 0;
        fiveBill = 0;
        twoBill = 0;

        //Recibe el monto y elimina los tres ceros que el gobierno no ha eliminado para simplicidad del cálculo.
        amount = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el monto a retirar" +
                "(múltiplos de $2000): $"))/1000;
        //Validación Req. No funcional.
        if (amount % 2 == 0){
            if (amount >= 100){
                oneHBill = amount / 100;
                amount %= 100;//Actualice el monto a cangear por billetes de otra denominación.
            }
            if (amount >= 50){
                fiftyBill = amount / 50;
                amount %= 50;
            }
            if (amount >= 20){
                twentyBill = amount / 20;
                amount %= 20;
            }
            if (amount >= 10){
                tenBill = amount / 10;
                amount %= 10;
            }
            if (amount > 0){
                twoBill = amount / 2;
                amount %= 2;
            }

            JOptionPane.showMessageDialog(null,"Billetes de 100 mil: " + oneHBill
                    + "\nBilletes de 50 mil: " + fiftyBill
                    + "\nBilletes de 20 mil: " + twentyBill
                    + "\nBilletes de 10 mil: " + tenBill
                    + "\nBileltes de 5 mil: " + fiveBill
                    +"\nBilletes de 2 mil: " + twoBill);
        }else JOptionPane.showMessageDialog(null,"Sólo se permiten múltiplos de $2000");

    }

    public static void ResolverQuintoPunto(){
        long M, N, combinations, num, den;
        num = 1;
        den = 1;
        M = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingrese el numero M de elementos(M>0): "));
        if(M < 1){
            JOptionPane.showMessageDialog(null,"El número de elementos debe ser mayor a 0");
        }else {
            N = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Tomados de(N>0): "));
            if(N < 1){
                JOptionPane.showMessageDialog(null,"El número de elementos debe ser mayor a 0");
            }else{
                for (long i = M; i > N; i--){
                    num *= i;
                }
                if (M != N){
                    for(long j = M - N; j > 0; j--){
                        den *= j;
                    }
                }
                combinations = num / den;
                JOptionPane.showMessageDialog(null,"El número de combinaciones es: " + combinations);
            }
        }

    }

}
