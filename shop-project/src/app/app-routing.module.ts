import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomerListComponent} from './Users/customer-list/customer-list.component';
import {ProductTableComponent} from './Products/product-table/product-table.component';
import {LoginComponent} from './LoginScreen/login/login.component';
import {AuthGuard} from './Guards/auth.guard';
import {GlobalGuard} from './Guards/global.guard';

// Drogi do podmieniania outlet routera w appcomponencie.html
const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent, canActivate: [AuthGuard]},
  {path: 'users', component: CustomerListComponent, canLoad: [GlobalGuard]},
  {path: 'products', component: ProductTableComponent, canLoad: [GlobalGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
