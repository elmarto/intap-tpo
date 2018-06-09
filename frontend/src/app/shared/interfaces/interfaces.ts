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
