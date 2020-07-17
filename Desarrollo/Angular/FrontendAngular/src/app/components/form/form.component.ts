import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { Persona } from '../../models/persona';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  persona: Persona;
  persona1: Persona;
  persona2: Persona;
  personas = [];
  clave: string;
  nombre: string;
  direccion: string;
  telefono: string;

  constructor() {
    // Persona 1
    this.persona1 = new Persona();
    this.persona1.clave = '1';
    this.persona1.nombre = 'Juan';
    this.persona1.direccion = 'Av. 01';
    this.persona1.telefono = '777';
    this.personas.push(this.persona1);

    // Persona 2
    this.persona2 = new Persona();
    this.persona2.clave = '2';
    this.persona2.nombre = 'Gabriel';
    this.persona2.direccion = 'Av. 02';
    this.persona2.telefono = '999';
    this.personas.push(this.persona2);
    }

  ngOnInit() {
  }

  guardar() {
    const nuevaPersona = new Persona();
    nuevaPersona.clave = this.clave;
    nuevaPersona.nombre = this.nombre;
    nuevaPersona.direccion = this.direccion;
    nuevaPersona.telefono = this.telefono;
    this.personas.push(nuevaPersona);
    Swal.fire('Guardado', 'Realizado correctamente', 'success');
  }

  editar() {
    
  }

  eliminar(clave) {
    Swal.fire('Eliminado', 'Realizado correctamente', 'success');
  }

}
