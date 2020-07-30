import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-ecmascript',
    templateUrl: 'ecmascript.component.html'
})


export class EcmascriptComponent implements OnInit {
   
    constructor() { }

    ngOnInit() {
        this.imprimeArgumento('TFM');
     }

     @imprimeInformacionFuncion
     imprimeArgumento(parametro: string) {
        console.log(`Estoy en la funcion original. Parametro recibido es ${parametro}`);

     }

}

export  function imprimeInformacionFuncion(target: Object, propertyKey: string, descriptor: any) {

    const metodoOriginal = descriptor.value;
    console.log('Clase: ', target.constructor.prototype);
    console.log('Método: ', propertyKey);
    console.log('Property Descriptor: ', descriptor);

    descriptor.value = function (...args: any[]) {
        console.log('Argumentos de la funcion', args);
        console.log('Se va invocar la función ' + propertyKey);
        metodoOriginal.apply(this, args);
    }


    return descriptor;
}
