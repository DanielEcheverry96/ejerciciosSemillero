import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreacionPersonasComponent } from './nucleo/capa/principal/creacion-personas/creacion-personas.component';
import { ApoyoComponent } from './nucleo/capa/principal/apoyo/apoyo.component';
import { GestionarPersonasComponent } from './nucleo/capa/principal/gestionar-personas/gestionar-personas.component';
import { EdicionPersonasComponent } from './nucleo/capa/principal/edicion-personas/edicion-personas.component';

const routes: Routes = [
  { path: 'personas-crear', component: CreacionPersonasComponent },
  { path: 'personas-editar', component: EdicionPersonasComponent },
  { path: 'personas-gestionar', component: GestionarPersonasComponent },
  { path: 'componente-apoyo', component: ApoyoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
