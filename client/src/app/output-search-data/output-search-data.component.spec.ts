import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OutputSearchDataComponent } from './output-search-data.component';

describe('OutputSearchDataComponent', () => {
  let component: OutputSearchDataComponent;
  let fixture: ComponentFixture<OutputSearchDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OutputSearchDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OutputSearchDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
