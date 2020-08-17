import { Pipe } from '@angular/core';

@Pipe({
  name: 'localTime'
})
export class LocalTimePipe
{
    transform( _time : any ): string
    {
        if( typeof( _time ) == "undefined" || ! _time )

            return "";

        if( typeof( _time ) == "string" )

            return _time;

        let _hour : string = _time.hour + "";
        let _minute : string = _time.minute + "";

        if( _hour.length < 2 )

            _hour = "0" + _hour;

        if( _minute.length < 2 )

            _minute = "0" + _minute;

        return ( _hour + ":" + _minute );
    }
}