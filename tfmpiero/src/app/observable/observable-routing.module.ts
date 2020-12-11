import { ObservableComponent } from './observable.component';
import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

const routes: Routes = [
    { path: '', component: ObservableComponent }
];

export const observableRouting: ModuleWithProviders = RouterModule.forChild(routes);