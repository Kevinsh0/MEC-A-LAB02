package lab2_3.pkg1;

import java.util.Scanner;
/**
 *
 * @author Kevin
 */
public class Lab2_31 {

    static Scanner entrada = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int x, select=0; 

        double [] nums_rand = new double [100];
        
        System.out.println("\tNumeros Generados");
        System.out.println("Ingrese el tamaño del arreglo:");
        x = entrada.nextInt();
        
       for (int i = 0; i < x; i++)
           nums_rand [i] = (int)(Math.random()* 6);
        
       for (int i = 0; i < x; i++)
           System.out.print(nums_rand [i] + "\t");
       
        while (select != 5)
        {
            System.out.println("\nSeleccione una opción de cálculo:\n1.Media y Mediana\n2.Varianza\n3.Desviacion estandar\n4.Moda\n5.Finalizar");
            select = entrada.nextInt();
            
            if (select == 1)
                Media_Mediana(nums_rand,x); 
            else if (select == 2 || select == 3)
                VarianzaYDesviacion(nums_rand, x, select);
            else if (select == 4)
                Moda(nums_rand, x);
    }
    
}
    public  static void  Media_Mediana (double [] array, int a)
    {
        double media, mediana;
        double aux = 0;
        media = 0;
        for (int i = 0; i < a; i++ )
          media = array [i] + media;
        media = media / a;
        //ORDENAMIENTO DE ARRAY
        for(int i = 0; i < a; i++)
        {
           for (int j = 0; j < a; j++)
           {
               if(array[j] > array[i])
               {  aux = array[j];
                  array [j] = array [i];
                  array [i] = aux;
               }
           }
        }
        //CALCULO DE MEDIANA
        if(a % 2 == 0)    
            mediana = (array[(a-2)/2] + array [((a-2)/2)+1])/2;
            else
            mediana = array[(a-1)/2];
        System.out.println("Arreglo ordenado:");
        for(int i = 0; i < a; i++)
            System.out.print(array[i]+ "\t");
            System.out.print(" ");
            
            
        System.out.println("El valor de la media es:" + media+"\nEl valor de la mediana es de: " + mediana+"\n\n");
    }
 
    public static void VarianzaYDesviacion (double []array, int a, int seleccion)
    {
        double promedio = 0, sumatoria = 0;
        
        //CALCULO DE PROMEDIO
        for (int i = 0; i < a; i++)
            promedio += array [i];
        promedio /=a;
        
        for (int i = 0; i < a; i++)
            sumatoria +=  Math.pow(array[i] - promedio, 2);
        
        if (seleccion == 2)
        {
            sumatoria /=(a-1);
            System.out.println("El valor de la varianza es de: "+ sumatoria);
        }
        else
        {
            sumatoria = Math.sqrt(sumatoria/(a-1));  
            System.out.println("El valor de la desviacion estandar es de: "+ sumatoria);
        }
    }
    
    public static void Moda (double []array, int a)
    {
        int repeticiones = 0, aux = 1 ; double numero = 0;
        
        for (int i = 0; i < a; i++)
        {
            for (int j = 1; j < a; j++)            
            { 
                if (array[i] == array [j])
                {  
                    repeticiones++;
                }
            }
            if (repeticiones > aux)
            {
                numero = array[i];
                aux = repeticiones;
            }
            repeticiones = 0;
        }
        System.out.println("La moda es:" + numero);
    }
    
}
