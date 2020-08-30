import { ComponenteService } from './componente.service';
import { componenteRouting } from './componente-routing.module';
import { NgModule } from '@angular/core';
import { ComponenteComponent } from './componente.component';
import { ModuloCompartidoModule } from '../modulo-compartido/modulo-compartido.module';
import { ListadoComparacionComponent } from './listado-comparacion/listado-comparacion.component';


@NgModule({
    imports: [componenteRouting, ModuloCompartidoModule],
    exports: [],
    declarations: [ComponenteComponent, ListadoComparacionComponent],
    providers: [ComponenteService],
})
export class ComponenteModule { }
