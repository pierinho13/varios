import { Optional, SkipSelf, NgModule } from '@angular/core';


@NgModule({
    imports: [],
    exports: [],
    declarations: [],
    providers: [],
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
