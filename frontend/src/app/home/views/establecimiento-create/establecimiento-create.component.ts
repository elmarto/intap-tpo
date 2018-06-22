import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder, FormArray } from '@angular/forms';
import { EstablecimientosService, Establecimiento, Ciudad, Foto } from 'app/shared';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';

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
  ciudadSelected: Ciudad;
  ciudades: Ciudad[];
  filteredCiudades: Ciudad[];
  imageUrl = 'Clickee una foto para obtener su URL';

  get fotosEstablecimiento(): FormArray {
    return this.form.get('fotosEstablecimiento') as FormArray;
  }


  constructor(
    private formBuilder: FormBuilder,
    private establecimientoService: EstablecimientosService,
    private snackBar: MatSnackBar,
    private router: Router
  ) {
    establecimientoService.getCiudades().subscribe(ciudades => this.ciudades = ciudades);
    this.setReactiveForms();
    this.form.controls.ciudad.valueChanges.subscribe(nombreCiudad => {
      this.filteredCiudades = nombreCiudad ? this.filterCiudades(nombreCiudad) : this.ciudades.slice();
    });
    this.addFoto();
  }

  ngOnInit() {
  }

  private setReactiveForms() {
    this.form = this.formBuilder.group({
      nombre: [null, Validators.compose([Validators.required, Validators.maxLength(50)])],
      direccion: [null, Validators.compose([Validators.required, Validators.maxLength(50)])],
      ciudad: [null, Validators.compose([Validators.required])],
      descripcion: [null, Validators.compose([Validators.required, Validators.maxLength(200)])],
      fotosEstablecimiento: this.formBuilder.array([]),
      mapa: this.formBuilder.group({
        lat: [null, Validators.compose([Validators.required])],
        lon: [null, Validators.compose([Validators.required])]
      }),
      estrellas: [1, Validators.compose([Validators.required, Validators.min(1), Validators.max(5)])]
    });
  }

  addFoto() {
    const nextId = this.fotosEstablecimiento.controls.length + 1;
    const foto: Foto = { id: nextId, url: '' };
    this.fotosEstablecimiento.push( this.formBuilder.group(foto));
  }

  removeFoto(index) {
    this.fotosEstablecimiento.removeAt(index);
  }

  selectCiudad(ciudad) {
    this.ciudadSelected = ciudad;
  }

  filterCiudades(nombre: string) {
    return this.ciudades.filter(ciudad =>
      ciudad.nombre.toLowerCase().indexOf(nombre.toLowerCase()) === 0);
  }

  loadImage(url: string) {
    this.imageUrl = url;
  }

  onSubmit() {
    const ctrl = this.form.controls;
    const registerRequest: Establecimiento = {
      uid: '',
      nombre: ctrl.nombre.value,
      direccion: ctrl.direccion.value,
      ciudad: this.ciudadSelected,
      estrellas: ctrl.estrellas.value,
      descripcion: ctrl.descripcion.value,
      mapa: ctrl.mapa.value,
      fotosEstablecimiento: []
    };
    ctrl.fotosEstablecimiento.value.forEach(foto => {
      registerRequest.fotosEstablecimiento.push({ url: foto.url });
    });
    this.establecimientoService.create(registerRequest).subscribe(response => {
      this.snackBar.open('Establecimiento guardado exitosamente', null, { duration: 2000 });
      this.router.navigate(['/establecimientos']);
    });
  }

}
