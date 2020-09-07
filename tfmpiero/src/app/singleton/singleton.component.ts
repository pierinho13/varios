import { Component, OnInit } from '@angular/core';
import { TransmisorService } from '../core/transmisor/transmisor.service';

@Component({
    selector: 'app-singleton',
    templateUrl: 'singleton.component.html'
})

export class SingletonComponent implements OnInit {


    mostrar: boolean = false;

    constructor(private transmisorService : TransmisorService) { }

    ngOnInit() { 

        this.mostrar = this.transmisorService.obtieneMostrarContenidoOculto();
    }

    cambiarValorMostrar() {
        this.mostrar =  this.transmisorService.cambiarMostrarContenidoOculto();
    }

}