package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
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


      short option;
      try {
        option = Short.parseShort(scan.next());
      } catch (Exception e) {
        System.out.println("Entre com uma opção válida!");
        continue;
      }

      if (option == 1) {

        System.out.println("Entre com a sua idade:");

        short age;
        try {
          age = Short.parseShort(scan.next());
        } catch (Exception e) {
          System.out.println("Entre com uma opção válida!");
          continue;
        }

        if (age < 18) {
          menores.add(age);
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (age < 50) {
          adultos.add(age);
          System.out.println("Pessoa adulta, catraca liberada!");
        } else {
          adultos50.add(age);
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        }

      } else if (option == 2) {
        loop = false;
        int menoresTotal = menores.size();
        int adultosTotal = adultos.size();
        int adultos50Total = adultos50.size();
        int total = menoresTotal + adultosTotal + adultos50Total;

        if (total == 0) {
          System.out.println("Entre com uma opção válida!");
          continue;
        }

        loadRelatorio(menoresTotal, adultosTotal, adultos50Total, total);
      }

    } while (loop);

    scan.close();
  }


  /**
   * Method LoadRelatorio.
   */
  public static void loadRelatorio(int menores, int adultosTotal, int adultos50, int total) {

    String sb = "----- Quantidade -----" + "\n"
            + "menores: " + menores + "\n"
            + "adultas: " + adultosTotal + "\n"
            + "a partir de 50: " + adultos50 + "\n\n"
            + "----- Percentual -----" + "\n"
            + "menores: " + percentage(menores, total) + "%" + "\n"
            + "adultas: " + percentage(adultosTotal, total) + "%" + "\n"
            + "a partir de 50: " + percentage(adultos50, total) + "%" + "\n\n"
            + "TOTAL: " + total;


    System.out.println(sb);
  }

  /**
   * Method percentage.
   */
  public static String percentage(double value, double total) {
    DecimalFormat df = new DecimalFormat();
    df.applyPattern("0.00");

    return df.format((value * 100) / total);
  }

}
