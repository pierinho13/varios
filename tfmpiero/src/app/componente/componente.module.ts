import { componenteRouting } from './componente-routing.module';
import { NgModule } from '@angular/core';
import { ComponenteComponent } from './componente.component';
import { ModuloCompartidoModule } from '../modulo-compartido/modulo-compartido.module';


@NgModule({
    imports: [componenteRouting, ModuloCompartidoModule],
    exports: [],
    declarations: [ComponenteComponent],
    providers: [],
})
export class ComponenteModule { }
