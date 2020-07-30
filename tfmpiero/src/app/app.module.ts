import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { appRouting } from './app-routing.module';
import { IntroduccionComponent } from './introduccion/introduccion.component';

@NgModule({
  declarations: [
    AppComponent,
    IntroduccionComponent
  ],
  imports: [
    BrowserModule,
    appRouting
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
