import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-creacion-persona',
  templateUrl: './creacion-persona.component.html',
  styleUrls: ['./creacion-persona.component.css']
})
export class CreacionPersonaComponent implements OnInit {

  /**
   * Arreglo para asignar el tipo de identificacion correspondiente a cada persona
   */
  tipoIdentificacion: string[] = ['Cedula', 'Tarjeta Identidad', 'Pasaporte'];

  /**
   * Se definen los atributos de persona.
   * Se crean una lista de persona con varias personas creadas
   */
  personas: {
    id: number,
    numIdentificacion: string,
    nombre: string,
    apellido: string,
    tipoIdentificacion: string
  }[] = [
    {
      'id': 1,
      'numIdentificacion': '1034526578',
      'nombre': 'Pepe',
      'apellido': 'Perez',
      'tipoIdentificacion': this.tipoIdentificacion[0]
    },
    {
      'id': 2,
      'numIdentificacion': '1739486378342',
      'nombre': 'Sarah',
      'apellido': 'Gonzales',
      'tipoIdentificacion': this.tipoIdentificacion[1]
    },
    {
      'id': 3,
      'numIdentificacion': '34356574723',
      'nombre': 'Carlos',
      'apellido': 'Marin',
      'tipoIdentificacion': this.tipoIdentificacion[2]
    }
  ];


  constructor() { }

  ngOnInit() {

  }

}
