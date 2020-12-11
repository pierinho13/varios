import { BehaviurSubjectComponent } from './behaviur-subject.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
    { path: '', component: BehaviurSubjectComponent },
];

export const behaviurSubjectRouting = RouterModule.forChild(routes);