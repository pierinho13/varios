import { NgModule } from '@angular/core';
import { ModuloCompartidoModule } from '../modulo-compartido/modulo-compartido.module';
import { ObservableService } from './observable.service';
import { observableRouting } from './observable-routing.module';
import { ObservableComponent } from './observable.component';


@NgModule({
    imports: [ModuloCompartidoModule, observableRouting ],
    exports: [],
    declarations: [ObservableComponent],
    providers: [ObservableService],
})
export class ObservableModule { }
