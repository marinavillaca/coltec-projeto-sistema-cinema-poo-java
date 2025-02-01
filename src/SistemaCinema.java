/* Trabalho Final - Cinema
 * Aluna: Marina Laura Villaça e Melo
 * Disciplina: POO - Coltec
 * Prof: Leandro Maia
*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SistemaCinema implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private List<Cinema> cinemas;

    public SistemaCinema() {
        cinemas = new ArrayList<>();
    }

    public void adicionarCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }
}
