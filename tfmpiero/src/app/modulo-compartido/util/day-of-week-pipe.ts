import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'dayOfWeekPipe'
})

export class DayOfWeekPipe implements PipeTransform {
    transform(value: number, ...args: any[]): any {
        
        if(value != null) { //enn javascript null == undefined 
            

            switch (value) {
                case 1:
                    return 'Lunes';
                case 2:
                    return 'Martes';
                case 3:
                    return 'Miercoles';
                case 4:
                    return 'Jueves';
                case 5:
                    return 'Viernes';
                case 6:
                    return 'Sabado';
                case 7:
                    return 'Domingo';
            
                default:
                    return '';
            }

        }
    }
}