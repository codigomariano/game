package ar.com.codigomariano;

import java.util.Scanner;

import ar.com.codigomariano.domain.Juego;
import ar.com.codigomariano.domain.Partida;
import ar.com.codigomariano.domain.Usuario;
import ar.com.codigomariano.domain.preguntas.PreguntaBinaria;
import ar.com.codigomariano.domain.preguntas.PreguntaMultiple;
import ar.com.codigomariano.enums.Categoria;
import ar.com.codigomariano.enums.Opcion;
import ar.com.codigomariano.exceptions.EmailNotFoundException;

public class App {
	private static Scanner sc = new Scanner(System.in);
	
	
    public static void main( String[] args ){
    	String email = null;
        Juego juego = new Juego();
        
        Usuario u = null;
        while(u == null) {
        	email = solicitarEmail();
        	
        	try {
        		u = new Usuario(email);        	        		
        	}catch(IllegalArgumentException e) {
        		System.out.println(e.getMessage());
        	}
        }
        
        juego.agregarUsuario(u);
        
        System.out.println("***************");
        System.out.println("INICIANDO PARTIDA");
        
        Partida p = null;
        
        while(p == null) {
        	
        	email = solicitarEmail();
        	
        	try {
				p = juego.iniciarPartida(email);
			} catch (EmailNotFoundException e) {
				 System.out.println(e.getMessage());
			}
        	
        }
        
        p.iniciar();
      
        PreguntaMultiple pm = new PreguntaMultiple("M222", "¿En qué año se produjo el descubrimiento de América?", Categoria.HISTORIA, Opcion.A, 100);
        pm.sumarOpcion(Opcion.A, "1492");
        pm.sumarOpcion(Opcion.B, "1516");
        pm.sumarOpcion(Opcion.C, "1671");
        pm.sumarOpcion(Opcion.D, "1744");
        
        
        PreguntaBinaria pb = new PreguntaBinaria("B754", "¿El ajedrez es un deporte olímpico?", Categoria.DEPORTES, Opcion.A, 220);
 
        pm.mostar();
        pb.mostar();
    }
    
    
    private static String solicitarEmail() {
    	System.out.print("Ingresa un email: ");
    	String email = sc.next();
    	
    	return email;
    }
}
