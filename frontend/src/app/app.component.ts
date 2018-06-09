import { Component } from '@angular/core';
import { StartupService } from './startup.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(
    private startupService: StartupService
  ) {
    this.startupService.init();
  }
}
