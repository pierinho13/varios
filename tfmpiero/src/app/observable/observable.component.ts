import { ObservableService } from './observable.service';
import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-observable',
    templateUrl: 'observable.component.html'
})

export class ObservableComponent implements OnInit {


    respuestaObservable:string;
    mostrarCargando:boolean = false;

    constructor(private observableService: ObservableService) { }

    ngOnInit() { }

    
    obtieneResultadoFuncionAsincronaSimulada() {

        this.respuestaObservable = null;
        this.mostrarCargando = true;

        this.observableService.obtieneResultadoAsincronoSimulado().subscribe((respuesta: any) => {
            
            this.respuestaObservable = respuesta;
            this.mostrarCargando = false;
        });
    }
}