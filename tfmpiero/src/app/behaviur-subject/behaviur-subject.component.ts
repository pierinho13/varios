import { TransmisorService } from './../core/transmisor/transmisor.service';
import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-behaviur-subject',
    templateUrl: 'behaviur-subject.component.html'
})

export class BehaviurSubjectComponent implements OnInit {

    valorEmitir:string;

    constructor(private transmisorService: TransmisorService) { 

    }

    ngOnInit() { }


    emitir() {

        this.transmisorService.emitirNuevoDatoBehaviurSubject(this.valorEmitir);
    }
}