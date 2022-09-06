import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardLayoutRoutes } from './dashboard-layout.routing';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(DashboardLayoutRoutes),
  ]
})
export class DashboardLayoutModule { }
