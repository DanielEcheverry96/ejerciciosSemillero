import { Component, OnInit } from '@angular/core';
import { PersonaDTO } from './modelo/personaDTO';

@Component({
  selector: 'app-apoyo',
  templateUrl: './apoyo.component.html',
  styleUrls: []
})
export class ApoyoComponent implements OnInit {
  public mostrarFormulario: boolean;
  public persona: PersonaDTO;
  public personas: PersonaDTO[];

  constructor() { }

  ngOnInit() {
    this.persona = {
      id: '0',
      nombre: '',
      apellido: '',
      tipoIdentificacion: '',
      numeroIdentificacion: '',
      mayorEdad: false,
      fechaNacimiento: new Date(),
      sexo: ''
    };

    this.personas = [];
    this.mostrarFormulario = true;
  }

  mostrar(): void {
  }

  ocultar(): void {

  }

  guardar(): void {
    this.personas.push(this.persona);
    console.log('guardar()' + this.persona.nombre);
  }

  private borrar(): void {

  }

}
