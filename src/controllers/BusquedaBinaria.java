package controllers;

import models.Product;

public class BusquedaBinaria {

    public Product findProductByStock(Product[] products , int stock){
        sortProductsByStock(products);

        int bajo = 0;
        int alto = products.length - 1;
        while(bajo<= alto){
            int centro = (bajo + alto)/2;
            if(centro == stock){
                return products[centro];
            }
            //defino si voy a ala izquierda o derecha 
            if(centro > stock )
                alto = centro -1;
            else
                bajo = centro +1;
        }
        return null;


    }
    public int findProductIndexByStock(Product[] products , int stock){
        sortProductsByStock(products);

        int bajo = 0;
        int alto = products.length - 1;
        while(bajo<= alto){
            int centro = (bajo + alto)/2;
            if(products[centro].getStock() == stock){
                return centro;
            }
            //defino si voy a ala izquierda o derecha 
            if(products[centro].getStock() > stock )
                alto = centro -1;
            else
                bajo = centro +1;
        }
        return -1;
    }



    private void sortProductsByStock(Product[] products){
        int n = products.length;
        boolean y ;
        for(int i = 0 ; i< n-1 ;i++){
            y = false;
            for(int j = 0; j<n -1 -i; j++){
                if(products[j].getStock() > products[j+1].getStock()){
                Product aux = products[j];
                products[j]=products[j+1];
                products[j+1] = aux;
                y = true;
                }
            }
             if(!y )
                break;   
        }
        
    }

    
}
