import { DirectivaComponent } from './directiva.component';
import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

const routes: Routes = [
    { path: '', component: DirectivaComponent }
];

export const directivaRouting: ModuleWithProviders = RouterModule.forChild(routes);