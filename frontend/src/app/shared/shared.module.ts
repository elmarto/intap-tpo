
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NguCarouselModule } from '@ngu/carousel';

import { FlexLayoutModule } from '@angular/flex-layout';
import { MaterialModule } from './material/material.module';
import { HeaderComponent, FooterComponent } from './components';
import { EstablecimientosService, OfertasService, AuthService } from './services';
import { ServiciosService } from './services/servicios.service';


@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    MaterialModule,
    FlexLayoutModule,
    HttpClientModule,
    NguCarouselModule
  ],
  declarations: [
    HeaderComponent,
    FooterComponent
  ],
  providers: [
    AuthService,
    EstablecimientosService,
    OfertasService,
    ServiciosService
  ],
  exports: [
    CommonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    MaterialModule,
    FlexLayoutModule,
    HttpClientModule,
    NguCarouselModule,
    HeaderComponent,
    FooterComponent
  ],
  entryComponents: []
})
export class SharedModule {}
