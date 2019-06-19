/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.examenunidadtresdcs;


import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class EXamenDCS{
    public void imprimir(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println("");
        }
    
    }
    public int[][] Transformada6DCS(int dim, int n){
        System.out.println("Ejercicio 6:");
        int[][] matriz=new int[dim][dim];
        int contador=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(contador<=i){
                    matriz[i][j]=n;
                    n++;
                    contador++;
                }else{
                    matriz[i][j]=-1;
                }
            }contador=0;
            
        }
        return matriz;
    }
        public int[][] Transformada9DCS(int dim, int numInit){
        System.out.println("Ejercicio 9: ");
          int[][] matriz=new int[dim][dim];
          for (int i = 0; i < matriz.length ; i++) {
               for (int j = 0; j < matriz.length ; j++) {
                  if (j>=dim-(i+1)){
                      matriz[i][j] = numInit;
                      numInit++;
                     }else{
                matriz[i][j]=-1;
                }
            } ;
        }
          return matriz;
     } 
            public int[][] Transformada12DCS(int dim, int numInit){
        System.out.println("Ejercicio 12: ");
          int[][] matriz=new int[dim][dim];
          for (int i = 0; i < matriz.length ; i++) {
              for (int j = matriz[0].length-1; j>=0; j--) {
                  if (j>=i){
                      matriz[i][j] = numInit;
                      numInit++;
                     
                     }else{
                matriz[i][j]=-1;
                }
            }
        }
          return matriz;
     }
    public int[][] Transformada26DCS(int dim, int numInit){
        System.out.println("Ejercicio 26:");
        int[][] matriz=new int[dim][dim];
        int cont=0;
        for (int i = 0; i < matriz.length; i++) {
            if(cont%2==0){
                for (int j = matriz.length-1; j >=0; j--) {
                    matriz[i][j]=numInit;
                    numInit++;
                }
            }else{
                for (int j = 0; j < matriz.length; j++) {
                    matriz[i][j]=numInit;
                    numInit++;
                }
            }
            cont++;
        }
       
           
        return matriz;
    }

    public int[][] Transformada30DCS(int dim, int numInit){
        System.out.println("Ejercicio 30");
        int[][] matriz=new int[dim][dim];
        for (int Prin = 0; Prin < dim/2; Prin++) {
            for (int LDx = Prin; LDx <dim-Prin-1; LDx++) {
                matriz[LDx][dim-Prin-1]=numInit;
                numInit++;
            }
            for (int lix =dim-Prin-1; lix>Prin; lix--) {
                matriz[dim-Prin-1][lix]=numInit;
                numInit++;
            }
            for (int lxx =dim-Prin-1 ; lxx>Prin; lxx--) {
                matriz[lxx][Prin]=numInit;
                numInit++;
             }
            for (int lsx = Prin; lsx<dim-Prin-1; lsx++) {
                matriz[Prin][lsx]=numInit;
                numInit++;
            }
             
            if(dim%2!=0){
                matriz[dim/2][dim/2]=numInit;
            }
            
        }
    return matriz;
    }

    public void TodoGGMM(){
        EXamenDCS or=new EXamenDCS();
        Scanner leer=new Scanner(System.in);
        System.out.println("Ingrese nuevamente la dimencion de la matriz: ");
        int dim=leer.nextInt();
        System.out.println("Ingrese nuevamente el numero de inicio: ");
        int n=leer.nextInt();
        or.imprimir(or.Transformada6DCS(dim, n));
        or.imprimir(or.Transformada26DCS(dim, n));
        or.imprimir(or.Transformada12DCS(dim, n));
        or.imprimir(or.Transformada30DCS(dim, n));
        or.imprimir(or.Transformada9DCS(dim, n));
    }
    public static void main(String[] args) {
        EXamenDCS or=new EXamenDCS();
        System.out.println("INGRESE EL ALGORITMO QUE DESEA PROBAR");
        Scanner leer=new Scanner(System.in);
        int opcion =leer.nextInt();
        System.out.println("Ingrese la dimencion de la matriz: ");
        int dim=leer.nextInt();
        System.out.println("Ingrese el numero de inicio: ");
        int n=leer.nextInt();
        while (opcion!=0) {            
            switch(opcion){
            case 1: or.imprimir(or.Transformada6DCS(dim, n)); break;
            case 2: or.imprimir(or.Transformada9DCS(dim, n)); break;
            case 3: or.imprimir(or.Transformada12DCS(dim, n)); break;
            case 4: or.imprimir(or.Transformada26DCS(dim, n)); break;
            case 5: or.imprimir(or.Transformada30DCS(dim, n)); break;
            case 6: or.TodoGGMM(); break;
            
         
            
            default: System.out.println("Opción Inválida!!");break;
            }  
            System.out.println("INGRESE LA OPCIÓN DEL ALGORITMO QUE DESEA PROBAR");            
            opcion =leer.nextInt();
            System.out.println("Ingrese la dimencion de la matriz: ");
            dim=leer.nextInt();
            System.out.println("Ingrese el numero de inicio: ");
            n=leer.nextInt();
        }
    }
}
