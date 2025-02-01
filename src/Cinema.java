/* Trabalho Final - Cinema
 * Aluna: Marina Laura Villaça e Melo
 * Disciplina: POO - Coltec
 * Prof: Leandro Maia
*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cinema implements Serializable {
    private static final long serialVersionUID = 1L;

	protected String idCinema;
	protected String nomeCinema;
	protected String localCinema;
	
	// Outros atributos:
    private static List<Cinema> cinemas = new ArrayList<>(); 		// ArrayList com a lista de todos os cinemas
    ArrayList<Sala> salas;	
	
    // Construtores:
	public Cinema() {
		this.nomeCinema = "Indefinido";
	}
	
    public Cinema(String idCinema, String nomeCinema, String localCinema) throws IdExistenteException {
    	
        for (Cinema cinema : cinemas) {
            if (cinema.getIdCinema().equals(idCinema)) {
                throw new IdExistenteException("O ID " + idCinema + " já está em uso por outro cinema.");
            }
        }	
		
		this.idCinema = idCinema;
		this.nomeCinema = nomeCinema;
		this.localCinema = localCinema;
        cinemas.add(this); 	
        this.salas = new ArrayList<>();
	}
	
	// Gets e Sets:
	public String getIdCinema() {
		return idCinema;
	}
	
	public String getNomeCinema() {
		return nomeCinema;
	}
	
	public String getLocalCinema() {
		return localCinema;
	}
	
	public void setId(String idCinema) {
		this.idCinema = idCinema;
	}
	
	public void setLocal(String localCinema) {
		this.localCinema = localCinema;
	}
	
	public void setNomeCinema(String nomeCinema) {
		this.nomeCinema = nomeCinema;
	}
		

	// Métodos básicos:
    public static void listarCinemas() {
        if (cinemas.isEmpty()) {
            System.out.println("Nenhum cinema cadastrado.");
        } 
        
        else {
            System.out.println("\nLista de cinemas cadastrados:");
            
            for (Cinema cinema : cinemas) {
                System.out.println("ID-Cinema: " + cinema.getIdCinema() + "| Nome: " + cinema.getNomeCinema() + "| Local: " + cinema.getLocalCinema());
            }
        }
    }
    
    public void adicionarSala(Sala sala) throws NomeDuplicadoException {
        for (Sala s : salas) {
        	
            if (s.getNomeSala().equalsIgnoreCase(sala.getNomeSala())) {
                throw new NomeDuplicadoException("Já existe uma sala com o nome \"" + sala.getNomeSala() + "\" no cinema " + nomeCinema);
            }
        }
        salas.add(sala);
    }
    
	public void listarSalas(){
        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala cadastrada para o cinema " + getNomeCinema());
        } 
        
        else {
            System.out.println("\nLista de Salas do " + nomeCinema + ":");
            for (Sala sala : salas) {
                System.out.println(sala.getNomeSala() + " | Capacidade: " + sala.getCapacidade() + " pessoas.");
            }
        }
   	}

	
}


