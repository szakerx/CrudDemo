import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerListComponent } from './customer-list/customer-list.component';


const routes: Routes = [
    { path: '', redirectTo: 'customer', pathMatch: 'full' },
    { path: 'customer', component: CustomerListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
