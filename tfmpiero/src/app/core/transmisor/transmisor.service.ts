import { Optional, SkipSelf, Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable()
export class TransmisorService {
   
    mostrarContenidoOculto: boolean = false;


    private datosBehaviurSubjectSource : BehaviorSubject<any> = new BehaviorSubject<any>("A partir de aquí se van a cargar los distintos componentes:");

    datosBehaviurSubject$ : Observable<any> = this.datosBehaviurSubjectSource.asObservable();
    
    constructor(@Optional() @SkipSelf() parentService: TransmisorService ) {

        if( parentService ){
                //Se evita error de importarlo en otro modulo y que deje ser un singleton
                //si se permitiera importarlo en modulos distintos cada uno tendria su propia version del servicio y este servicio esta pensado para poder compartir datos entre quienes lo usen
                throw new Error( 'TransmisorService es un singleton y solo puede ser importado en CoreModule. No esta permitido importarlo en otro módulo. Para usar el servicio simplemente agreguelo al constructor del componente deseado' );
        }
    }
    

    obtieneMostrarContenidoOculto() {
        return this.mostrarContenidoOculto;
    }

    cambiarMostrarContenidoOculto() {
        this.mostrarContenidoOculto = !this.mostrarContenidoOculto;

        return this.mostrarContenidoOculto;
    }

    emitirNuevoDatoBehaviurSubject(valorEmitir: string) {
        this.datosBehaviurSubjectSource.next( valorEmitir );
    }
}