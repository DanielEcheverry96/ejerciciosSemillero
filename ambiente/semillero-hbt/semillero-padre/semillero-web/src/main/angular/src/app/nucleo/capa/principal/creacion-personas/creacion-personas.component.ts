import { Component, OnInit } from '@angular/core';
import { PersonaDTO } from '../apoyo/modelo/personaDTO';

@Component({
  selector: 'app-creacion-personas',
  templateUrl: './creacion-personas.component.html'
})
export class CreacionPersonasComponent implements OnInit {

  public tipoIdentificaciones: string[] = [
    'Cedula ciudadania',
    'Tarjeta Identidad',
    'Pasaporte'
  ];

  public persona: PersonaDTO;
  public personas: PersonaDTO[];

  public title = 'Crear Persona';

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

    this.personas = [];
  }

  mostrar(persona: PersonaDTO): void {
  }

  ocultar(): void {

  }

  guardar(): void {
    this.personas.push(this.persona);
  }

  private borrar(): void {

  }

}
