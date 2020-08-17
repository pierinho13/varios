import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'booleanPipe'
})

export class BooleanPipe implements PipeTransform {
    transform(value: boolean, ...args: any[]): any {
        
        if(value != null && typeof(value) !== 'undefined') {
            
            const valorParaTrue = "Sí";
            const valorParaFalse = "No";

            if(value === true ) {

                return valorParaTrue;
            } else {

                return valorParaFalse;
            }

        }
    }
}