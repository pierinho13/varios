import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { SingletonComponent } from './singleton.component';

const routes: Routes = [
    { path: '', component: SingletonComponent }
];

export const singletonRouting: ModuleWithProviders = RouterModule.forChild(routes);