import { behaviurSubjectRouting } from './behaviur-subject-routing.module';
import { BehaviurSubjectComponent } from './behaviur-subject.component';
import { NgModule } from '@angular/core';
import { ModuloCompartidoModule } from '../modulo-compartido/modulo-compartido.module';


@NgModule({
    imports: [behaviurSubjectRouting, ModuloCompartidoModule],
    declarations: [BehaviurSubjectComponent],
    providers: [],
})
export class BehaviurSubjectModule { }
