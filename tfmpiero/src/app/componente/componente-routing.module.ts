import { ComponenteComponent } from './componente.component';
import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { ListadoComparacionComponent } from './listado-comparacion/listado-comparacion.component';

const routes: Routes = [
    { path: '', component: ComponenteComponent },
    { path: 'listado-comparacion', component: ListadoComparacionComponent }
];

export const componenteRouting: ModuleWithProviders = RouterModule.forChild(routes);