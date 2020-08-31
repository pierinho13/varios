import { ModuloCompartidoModule } from './../modulo-compartido/modulo-compartido.module';
import { DirectivaComponent } from './directiva.component';
import { NgModule } from '@angular/core';
import { directivaRouting } from './directiva-routing.module';


@NgModule({
    imports: [directivaRouting, ModuloCompartidoModule],
    exports: [],
    declarations: [DirectivaComponent],
    providers: [],
})
export class DirectivaModule { }
