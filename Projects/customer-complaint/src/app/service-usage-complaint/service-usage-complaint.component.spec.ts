import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceUsageComplaintComponent } from './service-usage-complaint.component';

describe('ServiceUsageComplaintComponent', () => {
  let component: ServiceUsageComplaintComponent;
  let fixture: ComponentFixture<ServiceUsageComplaintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceUsageComplaintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceUsageComplaintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
