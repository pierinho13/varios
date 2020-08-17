import { ComponenteComponent } from './componente.component';
import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

const routes: Routes = [
    { path: '', component: ComponenteComponent },
];

export const componenteRouting: ModuleWithProviders = RouterModule.forChild(routes);