package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Principal.
 */
public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    boolean loop = true;
    Scanner scan = new Scanner(System.in);
    ArrayList<Short> menores = new ArrayList<>();
    ArrayList<Short> adultos = new ArrayList<>();
    ArrayList<Short> adultos50 = new ArrayList<>();

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Acessar o estabelecimento");
      System.out.println("2 - Finalizar sistema e mostar relatório");

      short option = parseShort(scan.next());
      if (option == 0) {
        System.out.println("Entre com uma opção válida!");
        continue;
      }

      if (option == 1) {

        System.out.println("Entre com a sua idade:");

        short age = parseShort(scan.next());

        if (age < 18) {
          menores.add(age);
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (age >= 18 && age < 50) {
          adultos.add(age);
          System.out.println("Pessoa adulta, catraca liberada!");
        } else {
          adultos50.add(age);
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        }

      } else if (option == 2) {

        loop = false;

      } else {
        System.out.println("Entre com uma opção válida!");
      }

    } while (loop);

    scan.close();
  }

  /**
   * Method parseShort.
   */
  public static short parseShort(String input) {
    try {
      return Short.parseShort(input);
    } catch (Exception e) {
      return 0;
    }
  }
}
