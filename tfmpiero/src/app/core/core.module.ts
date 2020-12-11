import { Optional, SkipSelf, NgModule } from '@angular/core';
import { TransmisorService } from './transmisor/transmisor.service';


@NgModule({
    imports: [],
    exports: [],
    declarations: [],
    providers: [TransmisorService],
})
export class CoreModule {
    constructor( @Optional() @SkipSelf() parentModule : CoreModule )
    {
        if( parentModule )
        {
            throw new Error( 'CoreModule is already loaded. Import it in the AppModule only' );
        }
    }
}
