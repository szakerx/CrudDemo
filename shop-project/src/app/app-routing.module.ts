import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomerListComponent} from './Users/customer-list/customer-list.component';
import {ProductTableComponent} from './Products/product-table/product-table.component';
import {LoginComponent} from './LoginScreen/login/login.component';


const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'users', component: CustomerListComponent},
  {path: 'products', component: ProductTableComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
