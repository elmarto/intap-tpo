import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { EstablecimientosService } from '../../../shared';

@Component({
  selector: 'app-establecimiento-create',
  templateUrl: './establecimiento-create.component.html',
  styleUrls: ['./establecimiento-create.component.scss']
})
export class EstablecimientoCreateComponent implements OnInit {

  form: FormGroup;
  estrellas = [
    { value: 1 },
    { value: 2 },
    { value: 3 },
    { value: 4 },
    { value: 5 }
  ];

  constructor(
    private formBuilder: FormBuilder,
    private establecimientoService: EstablecimientosService
  ) { }

  ngOnInit() {
    this.setReactiveForms();
  }

  private setReactiveForms() {
    this.form = this.formBuilder.group({
      nombre: [null, Validators.compose([Validators.required, Validators.maxLength(50)])],
      direccion: [null, Validators.compose([Validators.required, Validators.maxLength(50)])],
      ciudad: [null, Validators.compose([Validators.required, Validators.maxLength(50)])],
      descripcion: [null, Validators.compose([Validators.required, Validators.maxLength(200)])],
      estrellas: [null, Validators.compose([Validators.required, Validators.min(1), Validators.max(5)])]
    });
  }

  onSubmit(form) {
    const registerRequest = Object.assign({}, form);
    this.establecimientoService.create(registerRequest);
  }

}
