import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import { DashboardLayoutComponent } from './layouts/dashboard-layout/dashboard-layout.component';
import { AuthGuardService } from './services/auth-guard.service';

const routes: Routes = [

  {
    path: "dash",
    component: DashboardLayoutComponent,
    canActivate: [AuthGuardService],
    children: [
      {
        path: "",
        loadChildren: () => import("./layouts/dashboard-layout/dashboard-layout.module").then((m) => m.DashboardLayoutModule),
      },
    ],
  },
  {
    path: "",
    component: AuthLayoutComponent,
    children: [
      {
        path: "",
        loadChildren: () => import('./layouts/auth-layout/auth-layout.module').then(m => m.AuthLayoutModule)
      },
    ],
  },
  {
    path: "",
    redirectTo: "dash/recipient",
    pathMatch: "full",
  },
  {
    path: "**",
    redirectTo: "dash/recipient",
  }

];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, {
      useHash: true,
    })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
