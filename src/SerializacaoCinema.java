/* Trabalho Final - Cinema
 * Aluna: Marina Laura Villaça e Melo
 * Disciplina: POO - Coltec
 * Prof: Leandro Maia
*/

import java.io.*;

public class SerializacaoCinema {

	private static final String NOME_ARQUIVO_CINEMA = "./cinema.ser";

    // Serializando o sistema Cinema
    public static void salvarSistemaCinema(SistemaCinema sistemaCinema) {
        try {
            // Abro arquivo para receber os dados
            FileOutputStream arquivo = new FileOutputStream(NOME_ARQUIVO_CINEMA);

            // Associo o stream de serialização ao arquivo
            ObjectOutputStream serializador = new ObjectOutputStream(arquivo);

            // Serializo o objeto
            serializador.writeObject(sistemaCinema);

            serializador.close();
            arquivo.close();

            System.out.println("Sistema de Cinema serializado com sucesso!");
        } 
        catch (IOException e) {
            System.err.println("Erro ao serializar o sistema de cinema.");
            e.printStackTrace();
        }
    }

    // Desserializando o sistema Cinema
    public static SistemaCinema carregarSistemaCinema() {
        try {
            // Abro o arquivo para ler os dados
            FileInputStream arquivo = new FileInputStream(NOME_ARQUIVO_CINEMA);

            // Associo o stream de desserialização ao arquivo
            ObjectInputStream desserializador = new ObjectInputStream(arquivo);

            // Desserializo e faço o cast porque readObject retorna Object
            SistemaCinema sistemaDesserializado = (SistemaCinema) desserializador.readObject();

            desserializador.close();
            arquivo.close();

            System.out.println("Sistema do Cinema desserializado com sucesso!");
            return sistemaDesserializado;
        } 
        
        catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao desserializar o sistema de cinema.");
            e.printStackTrace();
        }  throw new RuntimeException("Falha ao carregar o sistema de cinema.");
    }   
}