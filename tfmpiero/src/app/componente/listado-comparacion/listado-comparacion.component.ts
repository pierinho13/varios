import { ComponenteService } from './../componente.service';
import { Component, OnInit } from '@angular/core';
import { $ } from 'protractor';

@Component({
    selector: 'app-listado-comparacion',
    templateUrl: 'listado-comparacion.component.html'
})

export class ListadoComparacionComponent implements OnInit {


    listadoObjetos: Array<any> = [];


    constructor(private componenteService:ComponenteService) { }

    ngOnInit() {

        this.listadoObjetos =  this.componenteService.obtieneVariableListadoObjetos();

     }


    eliminaUltimoValor() {
        //hacemos proceso en back end
        this.componenteService.eliminaUltimoValor();
    }

}