import { NgModule } from '@angular/core';
import { RouterModule, Routes, Resolve } from '@angular/router';
import { EstablecimientoListComponent } from './views/establecimiento-list/establecimiento-list.component';
import { LoginComponent } from './views/login/login.component';
import { EstablecimientoCreateComponent } from './views/establecimiento-create/establecimiento-create.component';
import { HomeComponent } from './views/home/home.component';

const componentRoutes: Routes = [
  { path: '', children: [
      { path: 'login', component: LoginComponent },
      { path: 'home', component: HomeComponent },
      { path: 'establecimientos', component: EstablecimientoListComponent },
      { path: 'establecimientos/create', component: EstablecimientoCreateComponent }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(componentRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class HomeRoutingModule { }
