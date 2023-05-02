import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LoginguardGuard } from './services/loginguard.guard';
import { SignupComponent } from './signup/signup.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

const routes: Routes = [
  {path:"signupView",component:SignupComponent},
  {path:"loginView",component:LoginComponent},
  {path:"adminView",component:AdminDashboardComponent,canActivate:[LoginguardGuard]},
  {path:"userView",component:UserDashboardComponent,canActivate:[LoginguardGuard]}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
