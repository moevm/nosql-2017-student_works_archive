import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainLayerComponent } from './main-layer.component';

describe('MainLayerComponent', () => {
  let component: MainLayerComponent;
  let fixture: ComponentFixture<MainLayerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainLayerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainLayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
