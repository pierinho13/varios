import { EcmascriptComponent } from './ecmascript.component';
import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { ListadoComparacionComponent } from '../componente/listado-comparacion/listado-comparacion.component';

const routes: Routes = [
    { path: '', component: EcmascriptComponent }
];

export const EcmascriptRouting: ModuleWithProviders = RouterModule.forChild(routes);
