/* Trabalho Final - Cinema
 * Aluna: Marina Laura Villaça e Melo
 * Disciplina: POO - Coltec
 * Prof: Leandro Maia
*/

public class SalaPremium extends Sala{
   
	private static final long serialVersionUID = 1L;
	
	// Valores padrão
    private static final String NOME_PADRAO = "Sala Premium";
    private static final int CAPACIDADE_PADRAO = 100;
	
    SalaPremium(Cinema cinema) {
        super(NOME_PADRAO, CAPACIDADE_PADRAO, cinema);
    }   
}