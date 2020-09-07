import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from "rxjs/operators";





@Injectable()
export class ObservableService {
   
    constructor() {

     }
     

     private obtieneNumeroRamdonAleatorio(min, max) {
        return Math.random() * (max - min) + min;
     }


    obtieneResultadoAsincronoSimulado(): Observable<any> {

        const tardanzaSimulada = this.obtieneNumeroRamdonAleatorio(2000,5000).toFixed(2);
        const tardanzaSimuladaOutput = (tardanzaSimulada/1000).toFixed(2);

        return of(`Este es el resultado del observable y ha tardado ${tardanzaSimuladaOutput} segundos`).pipe(delay(tardanzaSimulada)) ;
     }

     

    
}