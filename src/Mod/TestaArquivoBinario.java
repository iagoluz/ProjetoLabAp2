package Mod;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestaArquivoBinario {

    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        String nome;
        char sexo;
        int idade;
        double peso, altura;
        ArrayList <Pessoa> pessoas = new ArrayList();    
        File arquivo = new File("TurboActivate.dat");
       //
        try ( FileInputStream arq = new FileInputStream(arquivo)) {
            DataInputStream lerArq = new DataInputStream(arq);
            while (lerArq.available() > 0) {
                String nome1 = lerArq.readUTF();
                int idade1 = lerArq.readInt();
                char sex = lerArq.readChar();
                double fat = lerArq.readDouble();
                double altu = lerArq.readDouble();
               pessoas.add(new Pessoa(nome1, idade1, sex, fat, altu));
            }
            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
                
            }

        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        }

    }

}
