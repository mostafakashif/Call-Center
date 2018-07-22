import { TestBed, inject } from '@angular/core/testing';

import { ProvisionedServicesService } from './provisioned-services.service';

describe('ProvisionedServicesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProvisionedServicesService]
    });
  });

  it('should be created', inject([ProvisionedServicesService], (service: ProvisionedServicesService) => {
    expect(service).toBeTruthy();
  }));
});
