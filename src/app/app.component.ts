import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {


  constructor() {
  }

  getTitle(): string {
    return 'Paper RPG Users Pane';
  }
}
