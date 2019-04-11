import { Component, OnInit } from '@angular/core';
import { PersonaDTO } from '../apoyo/modelo/personaDTO';

@Component({
  selector: 'app-edicion-personas',
  templateUrl: './edicion-personas.component.html',
  styleUrls: []
})
export class EdicionPersonasComponent implements OnInit {

  public tipoIdentificaciones: string[] = [
    'Cedula ciudadania',
    'Tarjeta Identidad',
    'Pasaporte'
  ];

  public persona: PersonaDTO;

  public title = 'Editar Persona';

  constructor() { }

  ngOnInit() {
    this.persona = {
      id: '0',
      nombre: '',
      apellido: '',
      tipoIdentificacion: this.tipoIdentificaciones[0],
      numeroIdentificacion: '',
      mayorEdad: false,
      fechaNacimiento: new Date(),
      sexo: ''
    };
  }

}
