package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	System.out.println("Размер матрицы? ");
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
//        Scanner scanner = new Scanner(System.in);
//        int size = scanner.nextInt();
        System.out.println("1: Сгенерировать матрицу  \n2: Ввести самому\n");
        int c = Integer.parseInt(scanner.nextLine());
        LinearEquasionsMatrix matrix;
            matrix = new LinearEquasionsMatrix(size);
        if (c  == 1){
            matrix.generateRandomMatrix();
        } else {
            for (int i = 0; i < size; i++) {
                String s = scanner.nextLine();
                String[] tmp = s.split(" ");
                try {
                    matrix.setLine(tmp,size,i);
                } catch (UnsupportedOperationException e) {
                    System.out.println("Неправильная размерность матрицы");
                    scanner.close();
                    return ;
                }
            }
            System.out.println("Введите свободный столбец");
            String s = scanner.nextLine();
            String[] tmp = s.split(" ");
            int i =0 ;
            for (String s1 : tmp) {
                matrix.b[i++] = (Double.parseDouble(s1));
            }
        }
        scanner.close();
        matrix.Gaussian();

    }
}
