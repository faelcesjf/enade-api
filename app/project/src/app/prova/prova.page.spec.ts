import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ProvaPage } from './prova.page';

describe('ProvaPage', () => {
  let component: ProvaPage;
  let fixture: ComponentFixture<ProvaPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProvaPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ProvaPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
