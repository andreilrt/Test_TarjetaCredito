package test_tarjetacredito;

import java.math.BigInteger;

import java.util.Scanner;

public class TarjetaDeCredito {

    private BigInteger NumeroTarjeta;
    private Scanner Input;

    public TarjetaDeCredito() {
        NumeroTarjeta = new BigInteger("0");
        Input = new Scanner(System.in);
    }

    public BigInteger getNumeroTarjeta() {
        return NumeroTarjeta;
    }

    public void setNumeroTarjeta(BigInteger NumeroTarjeta) {
        this.NumeroTarjeta = NumeroTarjeta;
    }

    public void PedirNumeroTarjeta() {
        System.out.println("Por favor ingrese su codigo sin espacios ni caracteres adicionales");
        System.out.print("Ingrese su número de tarjeta de credito:");
        this.setNumeroTarjeta(Input.nextBigInteger());
    }
    
    public void  IdentificarTipoTarjeta(){
        if(this.getNumeroTarjeta().toString().charAt(0)=='4'){
            System.out.println("Su tarjeta de credito es VISA");
        }
        if(this.getNumeroTarjeta().toString().charAt(0)=='5'){
            System.out.println("Su tarjeta de credito es MASTERCARD");
        }
        if(this.getNumeroTarjeta().toString().charAt(0)=='6'){
            System.out.println("Su tarjeta de credito es DISCOVER");
        }
        if(this.getNumeroTarjeta().toString().charAt(0)=='3'){
            System.out.println("Su tarjeta de credito es AMEX");
        }    
    }  
}
