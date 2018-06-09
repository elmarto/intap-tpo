import { NgModule } from '@angular/core';


/* Modules */
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from '../shared';
import { HomeRoutingModule } from './home-routing.module';
import { NguCarouselModule } from '@ngu/carousel';
import { MatStepperModule, MatInputModule, MatDividerModule } from '@angular/material';

/* Components */
import { EstablecimientoListComponent } from './views/establecimiento-list/establecimiento-list.component';
import { LoginComponent } from './views/login/login.component';
import { EstablecimientoCreateComponent } from './views/establecimiento-create/establecimiento-create.component';
import { HomeComponent } from './views/home/home.component';
import { OfertaCreateComponent } from './views/oferta-create/oferta-create.component';
import { OfertaListComponent } from './views/oferta-list/oferta-list.component';


@NgModule({
  imports: [
    HttpClientModule,
    SharedModule,
    HomeRoutingModule,
    NguCarouselModule,
    MatStepperModule,
    MatInputModule,
    MatDividerModule
  ],
  providers: [],
  declarations: [
    LoginComponent,
    EstablecimientoListComponent,
    EstablecimientoCreateComponent,
    HomeComponent,
    OfertaCreateComponent,
    OfertaListComponent
  ]
})
export class HomeModule {}

