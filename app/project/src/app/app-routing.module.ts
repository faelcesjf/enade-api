import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './services/AuthGuard.service';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', loadChildren: './login/login.module#LoginPageModule' },
  {
    path: 'dashboard',
    loadChildren: './dashboard/dashboard.module#DashboardPageModule',
    canActivate: [AuthGuard]
  },
  {
    path: 'prova',
    loadChildren: () => import('./prova/prova.module').then( m => m.ProvaPageModule)
  },
  {
    path: 'relatorios',
    loadChildren: () => import('./relatorios/relatorios.module').then( m => m.RelatoriosPageModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }