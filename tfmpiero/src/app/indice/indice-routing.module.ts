import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { IndiceComponent } from './indice.component';

const routes: Routes = [
    { path: '', component: IndiceComponent }
];

export const indiceRouting: ModuleWithProviders = RouterModule.forChild(routes);