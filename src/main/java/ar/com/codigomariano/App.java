package ar.com.codigomariano;

import java.util.Scanner;

import ar.com.codigomariano.domain.Juego;
import ar.com.codigomariano.domain.Partida;
import ar.com.codigomariano.domain.Usuario;

public class App {
	private static Scanner sc = new Scanner(System.in);
	
	
    public static void main( String[] args ){
    	String email = null;
        Juego juego = new Juego();
        
        for(int cant = 0; cant < 5; cant++) {
        	email = solicitarEmail();
        	Usuario u = new Usuario(email);
        	juego.agregarUsuario(u);
        }
        
        System.out.println("***************");
        System.out.println("INICIANDO PARTIDA");
        
        boolean valido = false;
        while(!valido) {
        	email = solicitarEmail();
        	valido = juego.existeEmailRegistrado(email);
        }
        
        Partida p = juego.iniciarPartida(email);
        p.iniciar();
    }
    
    
    private static String solicitarEmail() {
    	System.out.print("Ingresa un email: ");
    	String email = sc.next();
    	
    	return email;
    }
}
