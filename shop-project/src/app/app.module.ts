import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CustomerListComponent} from './Users/customer-list/customer-list.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {MatListModule} from '@angular/material/list';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSortModule} from '@angular/material/sort';
import {MatIconModule, MatInputModule} from '@angular/material';
import {MatMenuModule} from '@angular/material/menu';
import {ProductTableComponent} from './Products/product-table/product-table.component';
import {MatButtonModule} from '@angular/material/button';
import {LoginComponent} from './LoginScreen/login/login.component';
import {MatCardModule} from '@angular/material/card';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatDialogModule} from '@angular/material/dialog';
import {ReactiveFormsModule} from '@angular/forms';
import {AuthGuard} from './Guards/auth.guard';
import {AuthService} from './Guards/auth.service';
import {GlobalGuard} from './Guards/global.guard';
import {TokenInterceptor} from './Guards/token.interceptor';
import {A11yModule} from '@angular/cdk/a11y';
import {ProductWindowComponent} from './Products/product-window/product-window.component';
import {MatSelectModule} from '@angular/material/select';
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    ProductTableComponent,
    LoginComponent,
    ProductWindowComponent,
    ConfirmDialogComponent
  ],
  entryComponents: [
    ProductWindowComponent,
    ConfirmDialogComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    MatListModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatTableModule,
    MatPaginatorModule,
    BrowserAnimationsModule,
    MatSortModule,
    MatInputModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    ReactiveFormsModule,
    A11yModule,
    MatSelectModule
  ],
  providers: [
    AuthGuard,
    AuthService,
    GlobalGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
