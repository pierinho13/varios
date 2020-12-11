import { NgModule } from '@angular/core';
import { ModuloCompartidoModule } from '../modulo-compartido/modulo-compartido.module';
import { SingletonComponent } from './singleton.component';
import { singletonRouting } from './singleton-routing.module';


@NgModule({
    imports: [ModuloCompartidoModule, singletonRouting ],
    exports: [],
    declarations: [SingletonComponent],
    providers: [],
})
export class SingletonModule { }
