import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Product} from '../product';
import {ProductsService} from '../products.service';
import {Supplier} from '../../Suppliers/Supplier';
import {SupplierService} from '../../Suppliers/supplier.service';

@Component({
  selector: 'app-product-window',
  templateUrl: './product-window.component.html',
  styleUrls: ['./product-window.component.scss']
})
export class ProductWindowComponent implements OnInit {

  private types: string[];
  private categories: string[];
  private suppliers: Supplier[];

  constructor(public dialogRef: MatDialogRef<ProductWindowComponent>,
              @Inject(MAT_DIALOG_DATA) public product: Product,
              private productsService: ProductsService,
              private supplierService: SupplierService) {}

  cancelClick() {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.LoadEnums();
  }

  LoadEnums() {
    this.productsService.getAllTypes().subscribe(data => {
      this.types = data;
    });
    this.productsService.getAllCategories().subscribe(data => {
      this.categories = data;
    });
    this.supplierService.getAllSuppliers().subscribe(data => {
      this.suppliers = data;
    });
  }
}
