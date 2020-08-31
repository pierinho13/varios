import { VolverDirective } from './directives/volver.directive';
import { NgModule }            from '@angular/core';
import { CommonModule, DatePipe }        from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { LocalDatePipe } from './util/local-date.pipe';
import { LocalTimePipe } from './util/local-time.pipe';
import { BooleanPipe } from './util/boolean-pipe';
import { ObjectToArrayPipe } from './util/object-to-array.pipe';
import { RouterModule } from '@angular/router';



@NgModule({
    imports:      [ 
        CommonModule, 
        RouterModule,
    ],
    declarations: [ 
        LocalDatePipe,
        LocalTimePipe,
        BooleanPipe,
        ObjectToArrayPipe,
        VolverDirective
    ],
    exports:      [ 
        CommonModule, 
        FormsModule, 
        ReactiveFormsModule, 
        LocalDatePipe,
        LocalTimePipe,
        BooleanPipe,
        ObjectToArrayPipe,
        VolverDirective
    ],
    providers:    [ DatePipe, LocalTimePipe],
    entryComponents : [  ]
})
export class ModuloCompartidoModule {}