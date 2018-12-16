package com.company;

import java.util.ArrayList;

public class LinearEquasionsMatrix {
    final int size;
    double matrix[][];
    double[] b;

    LinearEquasionsMatrix (int size){
        this.size = size;
        this.matrix = new double[size][size];
        b = new double[size];
    }

    public void generateRandomMatrix(){
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.matrix[i][j] = (int)(Math.random() * 100);
            }
            b[i] = (int)(Math.random() * 100);
        }

    }

    public void setLine(String[] strings, int size, int index){
        if (strings.length != size)
            throw new UnsupportedOperationException();
        int i = 0;
        for (String string : strings) {
            this.matrix[index][i++] = Double.parseDouble(string);
        }
    }




//    public void PrintMatrix(){
//        for (int i = 0; i < this.size; i++) {
//            for (int j = 0; j < this.size; j++) {
//                this.matrix[i][j];
//            }
//        }
//    }

    public double[] Gaussian(){

        for (int j = 0; j < size ; j++) {
            divideLine(j, matrix[j][j]);
            for (int i = 0; i < size ; i++) {
                if (i == j )continue;
                else subtractLine(i,j,matrix[i][j]);
            }
        }
        return b;
    }

    private void divideLine(int line, double coeff){
        for (int i = 0; i < size ; i++) {
            matrix[line][i] /= coeff;
        }
        b[line] /= coeff;
    }

    private void multiplyLine(int line, double coeff){
        for (int i = 0; i < size ; i++) {
            matrix[line][i] *= coeff;
        }
        b[line] *= coeff;
    }

    private void addLine(int line1,int line2){
        for (int i = 0; i < size ; i++) {
            matrix[line1][i] += matrix[line2][i] ;
        }
        b[line1] += b[line1];
    }

    private void addLine(int line1,int line2, double coeff){
        for (int i = 0; i < size ; i++) {
            matrix[line1][i] += matrix[line2][i] * coeff ;
        }
        b[line1] += b[line1] * coeff;
    }

    private void subtractLine(int line1,int line2){
        for (int i = 0; i < size ; i++) {
            matrix[line1][i] -= matrix[line2][i] ;
        }
        b[line1] -= b[line1];
    }
    private void subtractLine(int line1,int line2, double coeff){
        for (int i = 0; i < size ; i++) {
            matrix[line1][i] -= matrix[line2][i] * coeff;
        }
        b[line1] -= b[line1] * coeff;
    }

    private double findDet(double[][] matrix, int size){
        double det=0;
        if(size == 1)
        {
            det = matrix[0][0];
        }
        else if (size == 2)
        {
            det = matrix[0][0]*matrix[1][1] - matrix[1][0]*matrix[0][1];
        }
        else
        {
            det=0;
            for(int j1=0;j1<size;j1++)
            {
                double[][] m = new double[size-1][];
                for(int k=0;k<(size-1);k++)
                {
                    m[k] = new double[size-1];
                }
                for(int i=1;i<size;i++)
                {
                    int j2=0;
                    for(int j=0;j<size;j++)
                    {
                        if(j == j1)
                            continue;
                        m[i-1][j2] = matrix[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0,1.0+j1+1.0)* matrix[0][j1] * findDet(m, size-1);
            }
        }
        return det;
    }
}
