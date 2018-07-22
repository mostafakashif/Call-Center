import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { ProvisionedServicesService } from '../provisioned-services.service';
import { Customer } from '../customer';
import { Service } from '../service';
import { Complaint } from '../complaint';
import { Observable } from 'rxjs/Rx'

@Component({
  selector: 'app-service-usage-complaint',
  templateUrl: './service-usage-complaint.component.html',
  styleUrls: ['./service-usage-complaint.component.css']
})
export class ServiceUsageComplaintComponent implements OnInit {



  public selectedCustomerService: Service;
  public customer: Customer = new Customer();
  public customerComplaint: Complaint;
  public errorMsg: String;
  constructor(private route: ActivatedRoute, private router: Router, private provisionedServicesservice: ProvisionedServicesService) {

    this.route.params.subscribe(res => { this.customer.customerId = res.customerId });
  }

  ngOnInit() {
    this.customerComplaint = new Complaint();
    this.selectedCustomerService = new Service();
    this.getCustomerInformation();
  }

  submitComplaint() {

    if (!this.selectedCustomerService.name) {
      this.errorMsg = 'Sorry! Please choose service';
    }
    else if (!this.customerComplaint.description) {
      console.log('Empty service name3');
      this.errorMsg = 'Sorry! Please add complaint ';
    }

    else {
      this.customerComplaint.customerId = this.customer.customerId;
      this.customerComplaint.serviceId = this.selectedCustomerService.id;
      this.provisionedServicesservice.submitComplaint(this.customerComplaint).subscribe(
        res => console.log(res),
        err => this.handleComplaintError(err),
        () => console.log('done calling submitComplaint')
      );
      this.customerComplaint.description = '';
      this.selectedCustomerService = new Service();
      this.errorMsg = 'Complaint submitted successfully';
    }
  }



  getCustomerInformation() {

    
    this.provisionedServicesservice.getCustomerInformation(this.customer.customerId).subscribe(
      data => { this.customer = data },
      err => this.handleCustomerInformationError(err),
      () => console.log('Done loading Customer Information')
    );

    this.errorMsg = 'Customer information retrieved successfully';
  }

  public handleComplaintError(error: any) {
    
    this.customerComplaint.description = '';
    this.errorMsg = 'Error submit complaint,please try agian later';
  }
  public handleCustomerInformationError(error: any) {
    
    this.errorMsg = 'Error in retrieving customer information,please try agian later';
  }
}
