import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http'; 
import { ServiceUsageComplaintComponent } from './service-usage-complaint/service-usage-complaint.component';
import { ProvisionedServicesService } from './provisioned-services.service';
import { HomeComponent } from './home/home.component';
@NgModule({
  declarations: [
    AppComponent,
    ServiceUsageComplaintComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ProvisionedServicesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
