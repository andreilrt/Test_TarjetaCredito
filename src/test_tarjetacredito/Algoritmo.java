package test_tarjetacredito;

import java.math.BigInteger;

import java.util.Scanner;

public class Algoritmo {

    private TarjetaDeCredito ObjTarjetaDeCredito;
    private Scanner Input;

    public Algoritmo() {
        ObjTarjetaDeCredito = new TarjetaDeCredito();
        Input = new Scanner(System.in);
    }

    public boolean ValidarTamanos() {
        if (this.ObjTarjetaDeCredito.getNumeroTarjeta().toString().length() == 16) {
            return false;
        } else {
            System.out.println("Numero de tarjeta de credito erroneo, Por favor intentelo de nuevo\n");
            return true;
        }
    }

    public void Verificacion() {
        BigInteger Operacion = new BigInteger("0");
        BigInteger Suma = new BigInteger("0");
        BigInteger SumaImpar = new BigInteger("0");
        BigInteger SumaPar = new BigInteger("0");
        for (int c = 0; c < 16; c++) {
            if (c % 2 == 0) {
                Operacion = BigInteger.valueOf(((int) this.ObjTarjetaDeCredito.getNumeroTarjeta().toString().charAt(c) - 48) * 2);
                if (Operacion.compareTo(BigInteger.valueOf(9))>0) {
                    Operacion = (Operacion.divide(BigInteger.TEN)).add(Operacion.subtract(BigInteger.TEN));
                }
                SumaImpar = SumaImpar.add(Operacion);
            } else {
                SumaPar = SumaPar.add(BigInteger.valueOf((int) this.ObjTarjetaDeCredito.getNumeroTarjeta().toString().charAt(c) - 48));
            }
        }
        Suma = SumaImpar.add(SumaPar);
        Suma=Suma.remainder(BigInteger.TEN);
        if (Suma.equals(BigInteger.ZERO)) {
            System.out.println("Su tarjeta de credito tiene un numero valido");
        } else {
            System.out.println("Su tarjeta de credito tiene un numero invalido");
        }
    }

    public void Proceso() {
        char Recurrencia = 's';
        boolean Control = true;
        System.out.println("Bienvenid@ al programa que valida su codigo de Tarjeta de credito\n");
        while (Recurrencia == 's' || Recurrencia == 'S') {
            while (Control) {
                this.ObjTarjetaDeCredito.PedirNumeroTarjeta();
                Control = this.ValidarTamanos();
            }
            Control = true;
            this.Verificacion();
            this.ObjTarjetaDeCredito.IdentificarTipoTarjeta();
            System.out.println("\nQuiere digitar otro numero de tarjeta de credito??? S/N");
            Recurrencia = Input.next().charAt(0);
        }
        System.out.println("\nPrograma Finalizado");
    }
}
