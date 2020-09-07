import { RouterModule, Routes } from '@angular/router';
import { IntroduccionComponent } from './introduccion/introduccion.component';

const routes: Routes = [
    { path : '', loadChildren: './indice/indice.module#IndiceModule' },
    { path: 'introduccion', component: IntroduccionComponent },
    { path : 'ecmascript', loadChildren: './ecmascript/ecmascript.module#EcmascriptModule' },
    { path : 'componente', loadChildren: './componente/componente.module#ComponenteModule' },
    { path : 'directiva', loadChildren: './directiva/directiva.module#DirectivaModule' },
    { path : 'observable', loadChildren: './observable/observable.module#ObservableModule' },
    { path : 'singleton', loadChildren: './singleton/singleton.module#SingletonModule' },
    { path: '**', pathMatch:'full', redirectTo: '/' }
];

export const appRouting = RouterModule.forRoot(routes);