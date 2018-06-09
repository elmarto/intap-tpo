export interface Establecimiento {
  id: number;
  uid: string;
  nombre: string;
  direccion: string;
  ciudad: string;
  estrellas: number;
  hotel: Hotel;
  descripcion: string;
  mapa: Image;
  fotosEstablecimiento: Image[];
}

export interface Hotel {
  id: number;
  nombre: string;
  fotosHotel: Image[];
}

export interface Image {
  url: string;
}

export interface Oferta {
  id: number;
  nombre: string;
  precio: number; // precio de la habitacion
  cupo: number;
  mediosDePago: string;
  tipoHabitacion: string; // SIMPLE, DOBLE, TRIPLE
  establecimiento: Establecimiento;
  fechaDesde: string;
  fechaHasta: string;
  politicas: string; // Texto con las politicas
  servicios: string;
}

export interface TipoServicio {
  id: number;
  nombre: string;
  servicios: Servicio[];
}

export interface Servicio {
  id: number;
  nombre: string;
}
