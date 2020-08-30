import { Injectable } from '@angular/core';

@Injectable()
export class ComponenteService {
   
    private listadoObjetos: Array<any> = [
        
        {
            "value" : "1",
            "label" : "Angular"
        },
        {
            "value" : "2",
            "label" : "Jquery"
        },
        {
            "value" : "3",
            "label" : "Node"
        },
        {
            "value" : "4",
            "label" : "NPM",
        },
        {
            "value" : "5",
            "label" : "Ecmascript2015"
        }

        ];


    constructor() {

     }

     obtieneVariableListadoObjetos(): Array<any> {
        return this.listadoObjetos;
    }

    eliminaUltimoValor() {
        //hacemos proceso en back end
       return  this.listadoObjetos.splice(-1,1);
    }
    
}