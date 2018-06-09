import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfertaListComponent } from './oferta-list.component';

describe('OfertaListComponent', () => {
  let component: OfertaListComponent;
  let fixture: ComponentFixture<OfertaListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OfertaListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfertaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
