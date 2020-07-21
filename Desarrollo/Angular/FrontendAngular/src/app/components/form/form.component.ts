import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { Persona } from '../../models/persona';
import { PersonaDataService } from '../../services/persona.data.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  persona: Persona;
  nuevaPersona: Persona;
  personas: any;
  modalStatus: string;

  constructor(private service: PersonaDataService) { }

  ngOnInit() {
    this.obtenerPersonas();
    this.persona = new Persona();
    this.nuevaPersona = new Persona();
  }

  guardar() {
    this.service.create(this.persona).subscribe(res => {
      if (res) {
        Swal.fire('Guardado', 'Realizado correctamente', 'success');
        this.obtenerPersonas();
      }
    });
  }

  obtener(id){
    this.service.get(id).subscribe(res => {
      this.nuevaPersona = res;
    });
  }

  obtenerPersonas() {
    this.service.getAll().subscribe(res => {
      this.personas = res;
    });
  }

  editar() {
    this.service.update(this.nuevaPersona).subscribe(res => {
      this.nuevaPersona = res;
      this.obtenerPersonas();
    });
  }

  eliminar(id) {
    Swal.fire({
      title: '¿Seguro que desea eliminar la persona?',
      text: "¡No podra deshacer esta acción!",
      icon: 'warning',
      confirmButtonColor: '#3085d6',
      confirmButtonText: 'Si, eliminarlo'
    }).then((res) => {
      if (res.value) {
        this.service.delete(id).subscribe(res => {
          Swal.fire(
            'Eliminado',
            'La persona ha sido eliminado exitosamente',
            'success'
          )
          this.obtenerPersonas();
        })
      }
    });
  }

}
