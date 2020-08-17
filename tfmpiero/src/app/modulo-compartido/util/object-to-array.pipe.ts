import { PipeTransform, Pipe } from '@angular/core';

/**
 * Devuelve un array de objeto key, value
 */
@Pipe({name: 'objectToArray'})
export class ObjectToArrayPipe implements PipeTransform {
  transform(values, excluir: Array<any>): any {
    const array = [];
    // tslint:disable-next-line:forin
    for (const key in values) {

      if(values[key] && (!excluir || !excluir.includes(key))  ) {
        array.push({key:key,value:values[key]});
      }
    }
    return array;
  }
}