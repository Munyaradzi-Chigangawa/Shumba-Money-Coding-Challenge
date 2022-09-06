import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import { FormsModule } from '@angular/forms';
import { DashboardLayoutComponent } from './layouts/dashboard-layout/dashboard-layout.component';
import { RecipientComponent } from './pages/dashboard/recipient/recipient.component';
import { AuthGuardService } from './services/auth-guard.service';
import { HttpClientModule } from '@angular/common/http';
import { ComponentsModule } from './components/components.module';
import { AddRecipientComponent } from './pages/dashboard/add-recipient/add-recipient.component';
import { UpdateRecipientComponent } from './pages/dashboard/update-recipient/update-recipient.component';
import { ViewRecipientComponent } from './pages/dashboard/view-recipient/view-recipient.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthLayoutComponent,
    DashboardLayoutComponent,
    RecipientComponent,
    AddRecipientComponent,
    UpdateRecipientComponent,
    ViewRecipientComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    ComponentsModule
    
  ],
  providers: [AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
