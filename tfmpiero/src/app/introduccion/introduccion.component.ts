import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-introduccion',
    templateUrl: 'introduccion.component.html'
})

export class IntroduccionComponent implements OnInit {
    
    private atributoPrivado;

    constructor() { }

    ngOnInit() {

        // tslint:disable-next-line:prefer-const
        let numeros: Array<number> = [] ;
        
        numeros.push(1);
        numeros.push(2);
        numeros.push(3);
        // numeros.push("3");

     }
}