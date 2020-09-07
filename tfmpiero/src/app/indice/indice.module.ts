import { IndiceComponent } from './indice.component';
import { NgModule } from '@angular/core';
import { ModuloCompartidoModule } from '../modulo-compartido/modulo-compartido.module';
import { indiceRouting } from './indice-routing.module';
import { IndiceService } from './indice.service';


@NgModule({
    imports: [ModuloCompartidoModule, indiceRouting ],
    exports: [],
    declarations: [IndiceComponent],
    providers: [IndiceService],
})
export class IndiceModule { }
