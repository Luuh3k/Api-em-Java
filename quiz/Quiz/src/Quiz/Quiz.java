package Quiz;

import java.util.*;

public class Quiz {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String questao = "Quem foi o criador do java?";

        Collection<String> alternativas = new ArrayList<>();
        alternativas.add("Felipe brito");
        alternativas.add("Helder casado");
        alternativas.add("Vinicinho dos teclados");
        alternativas.add("Pai de todos");
        alternativas.add("James Gosling");

        String alternativaCorreta = "James Gosling";

        boolean respostaCerta = false;

        do {
            System.out.println(questao);
            //cast
            //embaralhando a ordem das alternativas
            Collections.shuffle((List<String>) alternativas);

            //mostrar as alternativas na tela
            for(int i = 0; i < alternativas.size(); i++) {
                System.out.println(
                        "[" + i + "] " + ((List<String>) alternativas).get(i)
                );
            }

            System.out.println("Quem você acha que foi? ಠ_ಠ: ");
            String resposta = scanner.nextLine();
            //Usei Scanner para travar o programa e esperar o usuário digitar a reposta.

            int respostaInt = Integer.parseInt(resposta);

            String valorDaReposta = ((List<String>)alternativas).get(respostaInt);

            if ( valorDaReposta.equals(alternativaCorreta)) {
                System.out.println("Mas tu é bom mesmo!");
                respostaCerta = true;
            } else {
                System.out.println("AAAAAH, pera ai pooh. tenta de novo");
            }

        } while (!respostaCerta); // no DoWhile eu a repetição, especificando a reposta como certa, eu paro essa repetição quando o usuário acertar.
    }
}

