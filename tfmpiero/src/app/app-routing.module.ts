import { RouterModule, Routes } from '@angular/router';
import { IntroduccionComponent } from './introduccion/introduccion.component';

const routes: Routes = [
    { path: 'introduccion', component: IntroduccionComponent },
    { path : 'ecmascript', loadChildren: './ecmascript/ecmascript.module#EcmascriptModule' },
    { path : 'componente', loadChildren: './componente/componente.module#ComponenteModule' },
    { path: '**', pathMatch:'full', redirectTo: '/' }
];

export const appRouting = RouterModule.forRoot(routes);