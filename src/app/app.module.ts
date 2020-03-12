import {BrowserModule} from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserService } from './service/user-service.service';

@NgModule({
// deklarowanie komponentow, dyrektyw i pipe//
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent
  ],
  // importowanie modulow z zewnetrznych bibliotek//
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  // serwisy dostepne dla calej aplikacji - serwisy zadeklarowane w komponencie sa dostepne lokalnie dla danego komponentu i jego dzieci//
  providers: [UserService],
  // miejsce zadeklarowania kompnentu od ktorego zacznie sie uruchamianie aplikacji //
  bootstrap: [AppComponent]
})
export class AppModule { }
