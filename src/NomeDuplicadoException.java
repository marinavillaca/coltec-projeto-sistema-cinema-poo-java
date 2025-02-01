/* Trabalho Final - Cinema
 * Aluna: Marina Laura Villaça e Melo
 * Disciplina: POO - Coltec
 * Prof: Leandro Maia
*/

// Não devem existir duas salas com o mesmo nome 

public class NomeDuplicadoException extends Exception {
	private static final long serialVersionUID = 1L;

	public NomeDuplicadoException(String mensagem) {
        super(mensagem);
    }
}