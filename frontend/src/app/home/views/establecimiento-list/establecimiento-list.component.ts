import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { NguCarousel } from '@ngu/carousel';
import { ActivatedRoute } from '@angular/router';
import { EstablecimientosService } from '../../../shared';

@Component({
  selector: 'app-establecimiento-list',
  templateUrl: './establecimiento-list.component.html',
  styleUrls: ['./establecimiento-list.component.scss']
})
export class EstablecimientoListComponent {
  establecimientos: any[] = null;

  constructor(
    public establecimientosService: EstablecimientosService
  ) {
    this.establecimientosService.all()
      .subscribe(response => this.establecimientos = response.establecimientos);
  }
}
