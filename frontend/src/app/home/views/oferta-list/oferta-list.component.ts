import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { NguCarousel } from '@ngu/carousel';
import { ActivatedRoute } from '@angular/router';
import { OfertasService } from '../../../shared';

@Component({
  selector: 'app-oferta-list',
  templateUrl: './oferta-list.component.html',
  styleUrls: ['./oferta-list.component.scss']
})
export class OfertaListComponent {
  ofertas;

  constructor(
    public ofertasService: OfertasService
  ) {
    this.ofertasService.all()
      .subscribe(response => this.ofertas = response);
  }

}
