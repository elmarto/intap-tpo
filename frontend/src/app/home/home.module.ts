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
    EstablecimientoCreateComponent
  ]
})
export class HomeModule {}

