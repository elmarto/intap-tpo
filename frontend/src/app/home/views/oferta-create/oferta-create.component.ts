import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { EstablecimientosService, Establecimiento, OfertasService, TipoServicio } from 'app/shared';
import { ServiciosService } from 'app/shared/services/servicios.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-oferta-create',
  templateUrl: './oferta-create.component.html',
  styleUrls: ['./oferta-create.component.scss']
})
export class OfertaCreateComponent implements OnInit {

  form: FormGroup;
  establecimientos: Establecimiento[];
  tiposHabitacion: any[];
  mediosDePago: any[];
  tipoServicios: TipoServicio[];

  constructor(
    private formBuilder: FormBuilder,
    private establecimientosService: EstablecimientosService,
    private serviciosService: ServiciosService,
    private ofertasService: OfertasService,
    private snackBar: MatSnackBar,
    private router: Router
  ) {
    this.establecimientosService.all().subscribe(establecimientos => {
      return this.establecimientos = establecimientos.filter(e => e.uid);
    });
    this.serviciosService.all().subscribe(tipoServicios => this.tipoServicios = tipoServicios);
    this.tiposHabitacion = [
      { value: 'SIMPLE' },
      { value: 'DOBLE' },
      { value: 'TRIPLE' }
    ];

    this.mediosDePago = [
      { value: 'VISA' },
      { value: 'MASTERCARD' },
      { value: 'AMERICAN EXPRESS' }
    ];
  }

  ngOnInit() {
    this.setReactiveForms();
  }

  private setReactiveForms() {
    this.form = this.formBuilder.group({
      nombre: [null, Validators.compose([Validators.required, Validators.maxLength(50)])],
      establecimiento: [null, Validators.compose([Validators.required])],
      precio: [null, Validators.compose([Validators.required, Validators.min(0)])],
      cupo: [null, Validators.compose([Validators.required, Validators.min(0), Validators.max(200)])],
      tipoHabitacion: [null, Validators.compose([Validators.required])],
      mediosDePago: [null, Validators.compose([Validators.required])],
      fechaDesde: [null, Validators.compose([Validators.required])],
      fechaHasta: [null, Validators.compose([Validators.required])],
      politicas: [null, Validators.compose([Validators.required])],
      // servicios: [null, Validators.compose([Validators.required])]
    });
  }

  onServicioChecked(servicio) {
    servicio.value = !servicio.value;
  }

  onSubmit(form) {
    const ctrl = this.form.controls;
    const request = {
      nombre: ctrl.nombre.value,
      precio: ctrl.precio.value,
      cupo: ctrl.cupo.value,
      mediosDePago: ctrl.mediosDePago.value,
      tipoHabitacion: ctrl.tipoHabitacion.value,
      establecimiento:  ctrl.establecimiento.value,
      fechaDesde: ctrl.fechaDesde.value.toISOString(),
      fechaHasta: ctrl.fechaHasta.value.toISOString(),
      politicas: ctrl.fechaHasta.value,
      servicios: ''
    };

    if (this.tipoServicios) {
      const servicios = [];

      this.tipoServicios.forEach(tipoServicio => {
        tipoServicio.servicios.forEach(servicio => {
          if (servicio.value) {
            servicios.push(servicio.nombre);
          }
        });
      });
      request.servicios = servicios.reduce((a, b) => a + ', ' + b);
    }

    this.ofertasService.create(request).subscribe(response => {
      this.snackBar.open('Oferta guardado exitosamente', null, { duration: 2000 });
      this.router.navigate(['/ofertas']);
    });
  }
}
