import { Component, OnInit } from '@angular/core';
import { $ } from 'protractor';

@Component({
    selector: 'app-listado-comparacion',
    templateUrl: 'listado-comparacion.component.html'
})

export class ListadoComparacionComponent implements OnInit {


    listadoObjetos: Array<any> = [
        
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


    constructor() { }

    ngOnInit() { }


    eliminaUltimoValor() {
        //hacemos proceso en back end
        this.listadoObjetos.splice(-1,1);
    }

}