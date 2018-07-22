import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Customer } from './customer';
import { Complaint } from './complaint';
import { environment } from '../environments/environment'; 


const httpOptions = {
  headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')

};

@Injectable({
  providedIn: 'root'
})
export class ProvisionedServicesService {

  protected submitComplaintUrl: string = environment.ComplaintSubmitServiceURL;

  protected customerInformationUrl: string = environment.CustomerInformationServicURL;



  constructor(private http: HttpClient) {


  }

  submitComplaint(complaint: Complaint) {

    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post(this.submitComplaintUrl, JSON.stringify(complaint), { headers: headers });
  }


  getCustomerInformation(customerId: number) {

    return this.http.get<Customer>(this.customerInformationUrl.concat(customerId.toString()));
  }
}
