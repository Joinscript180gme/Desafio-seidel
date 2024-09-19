/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos_numericos_desafio3_seidel;

/**
 *
 * @author hp
 */
public class Metodos_numericos_desafio3_seidel {

    public static void main(String[] args) {
        // Coeficientes de las ecuaciones
        double[][] A = {
            {52, 20, 25},
            {30, 50, 20},
            {18, 30, 55}
        };
        
        // Resultados
        double[] b = {4800, 5810, 5690};
        
        // Inicialización de las variables
        double[] x = {0, 0, 0}; // x1, x2, x3 inicializados en 0
        double[] prev_x = new double[3];
        
        int maxIter = 100;
        double tol = 1e-6; // Tolerancia para detener las iteraciones
        
        System.out.println("Iteración\t x1 \t\t x2 \t\t x3");
        for (int iter = 0; iter < maxIter; iter++) {
            // Guardar valores anteriores para comparación
            System.arraycopy(x, 0, prev_x, 0, 3);
            
            // Método de Gauss-Seidel
            x[0] = (b[0] - A[0][1] * x[1] - A[0][2] * x[2]) / A[0][0];
            x[1] = (b[1] - A[1][0] * x[0] - A[1][2] * x[2]) / A[1][1];
            x[2] = (b[2] - A[2][0] * x[0] - A[2][1] * x[1]) / A[2][2];
            
            // Imprimir los valores de las iteraciones
            System.out.printf("%d \t\t %.6f \t %.6f \t %.6f\n", iter + 1, x[0], x[1], x[2]);
            
            // Verificación de convergencia
            if (Math.abs(x[0] - prev_x[0]) < tol && Math.abs(x[1] - prev_x[1]) < tol && Math.abs(x[2] - prev_x[2]) < tol) {
                break;
            }
        }
        
        System.out.println("\nSolución final:");
        System.out.printf("x1 = %.6f\n", x[0]);
        System.out.printf("x2 = %.6f\n", x[1]);
        System.out.printf("x3 = %.6f\n", x[2]);
    }
}
