import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { NucleoModule } from './nucleo/nucleo.module';
import { AppComponent } from './app.component';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NucleoModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
