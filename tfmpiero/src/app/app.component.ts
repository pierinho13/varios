import { TransmisorService } from './core/transmisor/transmisor.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {
  
  title = 'tfmpiero';

  textoBehaviurSubject :string;
  private datosSubscription : Subscription;

  constructor(private transmisorService: TransmisorService ){

  }
  
  ngOnInit(): void {

    this.datosSubscription = this.transmisorService.datosBehaviurSubject$.subscribe( ( respuesta: any ) => {
            
      if( ! respuesta ) {
          
          return;
      }

      this.textoBehaviurSubject  = respuesta;
      

  } , ( _err: any ) => {
      console.log('aqui se realizan acciones en caso de error');
  });
  }

  ngOnDestroy(): void {
    this.datosSubscription.unsubscribe();
  }
}
