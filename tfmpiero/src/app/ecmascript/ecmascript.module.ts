import { ModuloCompartidoModule } from './../modulo-compartido/modulo-compartido.module';
import { EcmascriptComponent } from './ecmascript.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { EcmascriptRouting } from './ecmascript-routing.module';

@NgModule({
    imports: [ EcmascriptRouting, ModuloCompartidoModule ],
    declarations: [ EcmascriptComponent ],
    providers: []
})
export class EcmascriptModule { }