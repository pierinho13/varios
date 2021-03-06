import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { appRouting } from './app-routing.module';
import { IntroduccionComponent } from './introduccion/introduccion.component';
import { CoreModule } from './core/core.module';

@NgModule({
  declarations: [
    AppComponent,
    IntroduccionComponent
  ],
  imports: [
    BrowserModule,
    appRouting,
    CoreModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
