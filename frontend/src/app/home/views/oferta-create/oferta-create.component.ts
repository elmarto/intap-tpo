import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { EstablecimientosService, Establecimiento, OfertasService, TipoServicio } from 'app/shared';
import { ServiciosService } from 'app/shared/services/servicios.service';

@Component({
  selector: 'app-oferta-create',
  templateUrl: './oferta-create.component.html',
  styleUrls: ['./oferta-create.component.scss']
})
export class OfertaCreateComponent implements OnInit {

  form: FormGroup;
  establecimientos: Establecimiento[];
  tiposHabitacion: [
    { value: 'SIMPLE' },
    { value: 'DOBLE' },
    { value: 'TRIPLE' }
  ];
  tipoServicios: TipoServicio[];

  constructor(
    private formBuilder: FormBuilder,
    private establecimientosService: EstablecimientosService,
    private serviciosService: ServiciosService,
    private ofertasService: OfertasService
  ) {
    establecimientosService.all().subscribe(response => this.establecimientos = response.establecimientos);
    serviciosService.all().subscribe(tipoServicios => this.tipoServicios = tipoServicios);
  }

  ngOnInit() {
    this.setReactiveForms();
  }

  private setReactiveForms() {
    this.form = this.formBuilder.group({
      nombre: [null, Validators.compose([Validators.required, Validators.maxLength(50)])],
      establecimiento: [null, Validators.compose([Validators.required])],
      precio: [null, Validators.compose([Validators.required, Validators.min(0)])],
      cupo: [null, Validators.compose([Validators.required, Validators.min(0), Validators.max(5)])],
      tipoHabitacion: [null, Validators.compose([Validators.required])],
      fechaDesde: [null, Validators.compose([Validators.required])],
      fechaHasta: [null, Validators.compose([Validators.required])],
      politicas: [null, Validators.compose([Validators.required])],
      // servicios: [null, Validators.compose([Validators.required])]
    });
  }

  onSubmit(form) {
    const registerRequest = Object.assign({}, form);
    this.establecimientosService.create(registerRequest);
  }
}
