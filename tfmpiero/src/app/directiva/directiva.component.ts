import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-directiva',
    templateUrl: 'directiva.component.html'
})

export class DirectivaComponent implements OnInit {
   
    suma:number;
   
   
    constructor() {



        let a = 1;
        let b = 3;
        let suma = a + b; // resultado seria 4
        a = 7; // Asignamos otro valor a la variable a

     }

    ngOnInit() { }
}