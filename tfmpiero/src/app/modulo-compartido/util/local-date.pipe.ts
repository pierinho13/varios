import { Pipe } from '@angular/core';

@Pipe({
  name: 'localDate'
})
export class LocalDatePipe
{
    transform( _date : any ): string
    {
        if( typeof( _date ) == "undefined" || ! _date || ! _date.year )

            return "";

        let _year : string = _date.year + "";
        let _month : string = _date.monthValue + "";

        if( _month.length < 2 )

            _month = "0" + _month;

        let _day : string = _date.dayOfMonth + "";

        if( _day.length < 2 )

            _day = "0" + _day;

        return ( _day + "/" + _month + "/" + _year );
    }
}