import { Component, OnInit } from '@angular/core';
import { PersonaDTO } from '../apoyo/modelo/personaDTO';

@Component({
  selector: 'app-gestionar-personas',
  templateUrl: './gestionar-personas.component.html',
  styleUrls: []
})
export class GestionarPersonasComponent implements OnInit {
  public tipoIdentificaciones: string[] = [
    'Cedula ciudadania',
    'Tarjeta Identidad',
    'Pasaporte'
  ];
  public personas: PersonaDTO[];
  title = 'Gestionar Personas';

  constructor() { }

  ngOnInit() {
    this.personas = [
      {
        id: '0',
        nombre: 'Pepe',
        apellido: 'Perez',
        tipoIdentificacion: this.tipoIdentificaciones[0],
        numeroIdentificacion: '1243245445',
        mayorEdad: true,
        fechaNacimiento: new Date(1999, 11, 17),
        sexo: 'Hombre'
      },
      {
        id: '1',
        nombre: 'Sarah',
        apellido: 'Gonzales',
        tipoIdentificacion: this.tipoIdentificaciones[1],
        numeroIdentificacion: '83764735618',
        mayorEdad: false,
        fechaNacimiento: new Date(2006, 10, 20),
        sexo: 'Mujer'
      }
    ];
  }

}
