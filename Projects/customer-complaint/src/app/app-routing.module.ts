import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ServiceUsageComplaintComponent } from './service-usage-complaint/service-usage-complaint.component';
import { HomeComponent } from './home/home.component';
const routes: Routes = [
  {
    path:'complaint/:customerId',
    component:ServiceUsageComplaintComponent
  },
  {
    path:'home',
    component:HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
