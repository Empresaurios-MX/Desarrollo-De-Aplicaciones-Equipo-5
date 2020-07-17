import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Componentes para enrutar
import { FormComponent } from './components/form/form.component';

const routes: Routes = [
  {
    path: 'forms',
    component: FormComponent,
  },
  {
    path: '',
    redirectTo: '/forms',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
